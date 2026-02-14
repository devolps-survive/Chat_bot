// Get elements
const form = document.querySelector(".form-section");
const passwordInput = document.querySelector('input[type="password"]');
const submitBtn = document.querySelector(".btn");

// Basic form submit
submitBtn.addEventListener("click", function (e) {
  e.preventDefault();

  const inputs = form.querySelectorAll("input");
  let isValid = true;

  inputs.forEach((input) => {
    if (input.value.trim() === "") {
      input.style.border = "1px solid red";
      isValid = false;
    } else {
      input.style.border = "1px solid #ddd";
    }
  });

  if (isValid) {
    alert("Signup successful! 🎉");
    // later: send data to backend
  }
});
