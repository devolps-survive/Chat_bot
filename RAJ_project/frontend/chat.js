const sendBtn = document.getElementById("send-btn");
const userInput = document.getElementById("user-input");
const chatBox = document.getElementById("chat-box");
const chatHistory = document.getElementById("chat-history");

sendBtn.addEventListener("click", sendMessage);
userInput.addEventListener("keypress", function(e) {
    if (e.key === "Enter") sendMessage();
});

function sendMessage() {
    const msg = userInput.value.trim();
    if (!msg) return;

    appendMessage(msg, "user");
    addToHistory(msg);

    userInput.value = "";

    
}

function appendMessage(msg, sender) {
    const msgDiv = document.createElement("div");
    msgDiv.className = "chat-message " + (sender === "bot" ? "bot-msg" : "user-msg");
    msgDiv.textContent = msg;
    chatBox.appendChild(msgDiv);
    chatBox.scrollTop = chatBox.scrollHeight;
}

function addToHistory(msg) {
    const li = document.createElement("li");
    li.textContent = msg;
    chatHistory.appendChild(li);
}
