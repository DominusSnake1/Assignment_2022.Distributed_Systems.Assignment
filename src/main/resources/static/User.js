function addUser() {
    var user = {};
    user.user_type = document.getElementById("user_type").value;
    user.first_name = document.getElementById("first_name").value;
    user.last_name = document.getElementById("last_name").value;
    user.afm = document.getElementById("afm").value;
    user.area_code = document.getElementById("area_code").value;

    confirm(`Add (${user.user_type}) \"${user.first_name} ${user.last_name}\" [afm: ${user.afm} and area code: ${user.area_code}], to the database?`);

    fetch("http://127.0.0.1:8080/users/add", {
        method: 'POST',
        body: JSON.stringify({
            user_type: user.user_type,
            first_name: user.first_name,
            last_name: user.last_name,
            afm: user.afm,
            area_code: user.area_code
        }),
        headers: {
            'Content-type': 'application/json'
        }
    }).then(data => {console.log(data)})
        .then(r => alert("User has been added!"))
}

function deleteUser(id) {
    var u_id = id.value;

    if (confirm(`Are you sure you want to delete this user?`)) {
        fetch(`http://127.0.0.1:8080/users/delete/id=${u_id}`, {
            method: 'DELETE'
        }).then(r => alert("User has been deleted!"));
    } else {
        alert("User wasn't deleted");
    }
}

function loadUsersTable(data) {
     const table = document.getElementById('userList');

     for (var i = 0; i < data.length; i++) {
         var row =
            `<tr>
                <td style="border: 1px solid black;">${data[i].id}</td>
                <td style="border: 1px solid black;">${data[i].user_type}</td>
                <td style="border: 1px solid black;">${data[i].first_name}</td>
                <td style="border: 1px solid black;">${data[i].last_name}</td>
                <td style="border: 1px solid black;">${data[i].afm}</td>
                <td style="border: 1px solid black;">${data[i].area_code}</td>
                <td><button value="${data[i].id}" onclick="deleteUser(this)" style="color: red">DELETE</button></td>
            </tr>`

        table.innerHTML += row;
    }
}

function clearUserTable() {
    var table = document.getElementById('userList');
    table.innerHTML = "";
}

function printAllUsers() {
    clearUserTable();

    fetch('http://127.0.0.1:8080/users/')
        .then(response => response.json())
        .then(data => loadUsersTable(data));
}