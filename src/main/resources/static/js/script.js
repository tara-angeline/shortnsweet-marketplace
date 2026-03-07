const menuIcon = document.querySelector(".menu-icon");
const closeIcon = document.querySelector(".close-icon");
const navLinks = document.querySelector(".nav-links");

if (menuIcon && closeIcon && navLinks) {
    menuIcon.addEventListener("click", () => {
        navLinks.classList.add("active");
    });

    closeIcon.addEventListener("click", () => {
        navLinks.classList.remove("active");
    });
}

function togglePassword() {
    const passwordField = document.getElementById("password");
    const toggleIcon = document.querySelector(".toggle-password");

    if (passwordField.type === "password") {
        passwordField.type = "text";
    } else {
        passwordField.type = "password";
    }
}