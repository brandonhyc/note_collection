function fillTable(tableSelector, data) {

    var table = document.querySelector(tableSelector);

    for (let item of data) {
        var name = item.employee_name;
        var tr = document.createElement("tr");
        var td1 = document.createElement("td1");
        var text = document.createTextNode(name);
        td1.appendChild(text);
        tr.appendChild(td1);
        table.appendChild(tr);
    }

}