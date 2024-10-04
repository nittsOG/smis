<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Live Chat</title>
<!-- SockJS -->
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
<!-- STOMP -->
<script src="https://cdn.jsdelivr.net/npm/stompjs@2.3.3/dist/stomp.min.js"></script>



<style>
/* Basic styling for chat */
#chat-container {
	width: 500px;
	margin: 0 auto;
}

#messageArea {
	border: 1px solid #ccc;
	height: 300px;
	overflow-y: scroll;
	padding: 10px;
}

#messageForm {
	display: flex;
	margin-top: 10px;
}

#messageForm input {
	flex: 1;
	padding: 10px;
}

#messageForm button {
	padding: 10px;
}
</style>
</head>
<body>
	<!-- Add this above the message area -->
	<div>
		<label for="recipientInput">Recipient:</label> <input type="text"
			id="recipientInput" placeholder="Enter recipient username" required />
	</div>

	<div id="chat-container">
		<h2>Live Chat</h2>
		<div id="messageArea"></div>
		<form id="messageForm">
			<input type="text" id="messageInput"
				placeholder="Type your message..." autocomplete="off" required />
			<button type="submit">Send</button>
		</form>
	</div>

	<script>
		var stompClient = null;

		function connect() {
			var socket = new SockJS('/chat-websocket'); // Matches the registered endpoint
			stompClient = Stomp.over(socket); // This should now be recognized

			stompClient.connect({}, function(frame) {
				console.log('Connected: ' + frame);

				// Subscribe to public topic
				stompClient.subscribe('/topic/public', function(message) {
					showMessage(JSON.parse(message.body));
				});

				// Subscribe to user-specific queue
				stompClient.subscribe('/user/queue/messages',
						function(message) {
							showMessage(JSON.parse(message.body));
						});
			}, function(error) {
				console.log('STOMP error: ' + error);
			});
		}

		function sendMessage(event) {
			event.preventDefault();
			var messageInput = document.getElementById('messageInput');
			var messageContent = messageInput.value.trim();

			if (messageContent && stompClient) {
				var chatMessage = {
					sender : "${sessionScope.user.username}",
					recipient : "", // Handle recipient for one-to-one chat
					message : messageContent,
					senderType : "${sessionScope.user.senderType}",
					timestamp : new Date()
				};

				stompClient.send("/app/chat.sendMessage", {}, JSON
						.stringify(chatMessage));
				messageInput.value = '';
			}
		}

		function showMessage(message) {
			var messageArea = document.getElementById('messageArea');
			var messageElement = document.createElement('div');

			var senderLabel = message.senderType + " (" + message.sender
					+ "): ";
			messageElement.textContent = senderLabel + message.message;

			messageArea.appendChild(messageElement);
			messageArea.scrollTop = messageArea.scrollHeight;
		}

		document.getElementById('messageForm').addEventListener('submit',
				sendMessage);

		connect();
	</script>
</body>
</html>
