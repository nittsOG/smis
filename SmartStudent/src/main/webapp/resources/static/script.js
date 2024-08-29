document.addEventListener("DOMContentLoaded", function () {
  const passwordField = document.getElementById("password");
  const togglePassword = document.querySelectorAll(".toggle-password");

  togglePassword.forEach(function (toggle) {
    toggle.addEventListener("click", function () {
      const type = passwordField.type === "password" ? "text" : "password";
      passwordField.type = type;

      togglePassword.forEach((icon) => (icon.style.display = "none"));
      toggle.style.display = "block";
    });

    toggle.addEventListener("keypress", function (e) {
      if (e.key === "Enter") {
        toggle.click();
      }
    });
  });
});
