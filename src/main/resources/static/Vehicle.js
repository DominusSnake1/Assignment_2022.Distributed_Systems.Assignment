function addVehicle() {
    var veh = {};
    veh.o_afm = document.getElementById("o_afm").value;
    veh.brand = document.getElementById("brand").value;
    veh.model = document.getElementById("model").value;
    veh.kteo = document.getElementById("kteo").value;
    veh.regis = document.getElementById("regis").value;

    confirm(`Add ${veh.brand} ${veh.model} (${veh.kteo}) [${veh.regis}], to the database?`);

    fetch(`http://127.0.0.1:8080/vehicles/owner_afm=${veh.o_afm}`, {
        method: 'POST',
        body: JSON.stringify({
            owner_afm: veh.o_afm,
            brand: veh.brand,
            model: veh.model,
            kteo_id: veh.kteo,
            registration: veh.regis
        }),
        headers: {
            'Content-type': 'application/json'
        }
    }).then(data => {console.log(data)})
        .then(r => alert("Vehicle has been added!"));
}

function deleteVeh(id) {
    var u_id = id.value;

    if (confirm(`Are you sure you want to delete this vehicle?`)) {
        fetch(`http://127.0.0.1:8080/vehicles/admin/delete/id=${u_id}`, {
            method: 'DELETE'
        }).then(r => alert("Vehicle has been deleted!"));
    } else {
        alert("Vehicle wasn't deleted");
    }
}

function loadVehTable(data) {
    const table = document.getElementById('vehList');

    for (var i = 0; i < data.length; i++) {
        var row =
            `<tr>
                <td>${data[i].id}</td>
                <td>${data[i].owner_afm}</td>
                <td>${data[i].brand}</td>
                <td>${data[i].model}</td>
                <td>${data[i].kteo_id}</td>
                <td>${data[i].registration}</td>
                <td sec:authorize="hasRole('ROLE_ADMIN')"><button value="${data[i].id}" onclick="deleteVeh(this)">DELETE</button></td>
            </tr>`

        table.innerHTML += row;
    }
}

function clearVehTable() {
    var table = document.getElementById('vehList');
    table.innerHTML = "";
}

function printAllVehicles() {
    clearVehTable();

    fetch('http://127.0.0.1:8080/vehicles/')
        .then(response => response.json())
        .then(data => loadVehTable(data));
}