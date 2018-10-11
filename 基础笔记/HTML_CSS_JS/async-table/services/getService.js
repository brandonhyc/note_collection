async function get(url) {
    return fetch(url);
}

async function getEmployees() {

    var response = await get(
        "http://dummy.restapiexample.com/api/v1/employees");

    return response.json();
}
    