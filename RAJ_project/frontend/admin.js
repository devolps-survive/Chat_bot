// Mock uploaded files array
let uploadedFiles = [];

const uploadForm = document.getElementById("upload-form");
const fileInput = document.getElementById("file-input");
const uploadStatus = document.getElementById("upload-status");
const documentsTable = document.getElementById("documents-table").querySelector("tbody");

// Handle file upload
uploadForm.addEventListener("submit", (e) => {
    e.preventDefault();
    const files = Array.from(fileInput.files);
    files.forEach(file => {
        const uploadedOn = new Date().toLocaleString();
        uploadedFiles.push({
            name: file.name,
            type: file.type,
            uploadedOn: uploadedOn
        });
    });
    uploadStatus.textContent = `${files.length} file(s) uploaded successfully!`;
    fileInput.value = "";
    renderDocuments();
});

// Render documents table
function renderDocuments() {
    documentsTable.innerHTML = "";
    uploadedFiles.forEach((file, index) => {
        const tr = document.createElement("tr");
        tr.innerHTML = `
            <td>${file.name}</td>
            <td>${file.type || "Unknown"}</td>
            <td>${file.uploadedOn}</td>
            <td>
                <button class="actions-btn delete-btn" onclick="deleteFile(${index})">Delete</button>
            </td>
        `;
        documentsTable.appendChild(tr);
    });
}

// Delete file
function deleteFile(index) {
    uploadedFiles.splice(index, 1);
    renderDocuments();
}
