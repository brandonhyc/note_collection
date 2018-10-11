async function clickButton() {

    var data = await getEmployees();
    fillTable("table", data);

}