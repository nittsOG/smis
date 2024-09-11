function toggleSidebar() {
    var sidebar = document.getElementById("sidebar");
    var mainContent = document.getElementById("main-content");

    if (sidebar.style.width === "250px") {
        sidebar.style.width = "0";
        mainContent.classList.remove("open");
    } else {
        sidebar.style.width = "250px";
        mainContent.classList.add("open");
    }
}
