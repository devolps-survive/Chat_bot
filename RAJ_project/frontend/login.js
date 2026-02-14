let isLogin = true;

function toggleForm() {
    const title = document.getElementById("form-title");
    const nameField = document.getElementById("name-field");
    const button = document.querySelector(".btn");
    const switchText = document.querySelector(".switch span");

    if (isLogin) {
        title.innerText = "Signup";
        nameField.classList.remove("hidden");
        button.innerText = "Sign up";
        switchText.innerText = "Login";
    } else {
        title.innerText = "Login";
        nameField.classList.add("hidden");
        button.innerText = "Sign in";
        switchText.innerText = "Register for free";
    }

    isLogin = !isLogin;
}
