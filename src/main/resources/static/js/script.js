const menuIcon = document.querySelector(".bx-menu");
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

function togglePassword(icon) {

    const password = document.getElementById("password");

    if (password.type === "password") {
        password.type = "text";
        icon.classList.replace("bx-show", "bx-hide");
    } else {
        password.type = "password";
        icon.classList.replace("bx-hide", "bx-show");
        }
}