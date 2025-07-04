const API = "http://localhost:8080/api/contacts";

const form = document.getElementById("contact-form");
const list = document.getElementById("contact-list");
let editingId = null;

function loadContacts() {
    fetch(API)
        .then(res => res.json())
        .then(data => {
            list.innerHTML = "";
            data.forEach(contact => {
                const li = document.createElement("li");
                li.className = "list-group-item d-flex justify-content-between align-items-center";
                li.innerHTML = `
          <div>
            <strong>${contact.name}</strong> — ${contact.email}, ${contact.phone}
          </div>
          <div>
            <button class="btn btn-sm btn-info me-1" onclick="editContact(${contact.id}, '${contact.name}', '${contact.email}', '${contact.phone}')">Edit</button>
            <button class="btn btn-sm btn-danger" onclick="deleteContact(${contact.id})">Delete</button>
          </div>
        `;
                list.appendChild(li);
            });
        });
}

form.onsubmit = (e) => {
    e.preventDefault();

    const phoneValue = form.phone.value.trim();
    const phoneRegex = /^\+?\d+$/;

    if (!phoneRegex.test(phoneValue)) {
        alert("Invalid phone number. Only digits allowed, optionally starting with +.");
        return;
    }

    const contact = {
        name: form.name.value,
        email: form.email.value,
        phone: phoneValue
    };

    if (editingId) {
        fetch(`${API}/${editingId}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(contact)
        }).then(() => {
            editingId = null;
            form.reset();
            loadContacts();
        });
    } else {
        fetch(API, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(contact)
        }).then(() => {
            form.reset();
            loadContacts();
        });
    }
};

function deleteContact(id) {
    fetch(`${API}/${id}`, { method: "DELETE" })
        .then(() => loadContacts());
}

function editContact(id, name, email, phone) {
    editingId = id;
    form.name.value = name;
    form.email.value = email;
    form.phone.value = phone;
}

loadContacts();