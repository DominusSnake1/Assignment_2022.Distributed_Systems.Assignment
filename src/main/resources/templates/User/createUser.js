function addUser() {
    var user = {};
    user.first_name = document.getElementById("first_name").value;
    user.last_name = document.getElementById("last_name").value;
    user.afm = document.getElementById("afm").value;
    user.area_code = document.getElementById("area_code").value;

    confirm(`Add \"${user.first_name} ${user.last_name}\" with afm: ${user.afm}, from: ${user.area_code} to the database?`);

    fetch("http://127.0.0.1/8080/users/add", {
        method: 'POST',
        body: JSON.stringify({
            user_type: "USER",
            first_name: user.first_name,
            last_name: user.last_name,
            afm: user.afm,
            area_code: user.area_code
         }),
        headers: {
            'Content-type': 'application/json'
        }
    }).then(data => {console.log(data)})
}