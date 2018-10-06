
var getBtn = document.querySelector("#get-btn");
getBtn.addEventListener("mouseup", 
    () => printGetResult("#display-plane", "#url-input"));

var postBtn = document.querySelector("#post-btn");
postBtn.addEventListener("mouseup", 
    () => printPostResult("#display-plane", "#url-input", "#user-signUp-component"));
                
function printPostResult(divSelector, inputSelector, formSelector) {
    var url = document.querySelector(inputSelector).value;
    var formData = new FormData(document.querySelector(formSelector));
    var displayPlane = document.querySelector(divSelector);
    displayPlane.innerHTML = "";
    
    servicePost(url, formData)
        .then((response) => {
            console.log('response: ', response);
            
            var p = document.createElement("p");
            var text = document.createTextNode(JSON.stringify(response.id));
            
            p.appendChild(text);
            displayPlane.appendChild(p);
        })
}


function printGetResult(divSelector, inputSelector) {
    var url = document.querySelector(inputSelector).value;
    var displayPlane = document.querySelector(divSelector);
    displayPlane.innerHTML = "";

    serviceGet(url)
        .then((response) => {
            console.log('response: ', response);
            var table = createTable(response);
            displayPlane.appendChild(table);
        }
    )
}

function createTable(content) {
    var table = document.createElement("table");
    for (let index in content) {
        var strUserId = JSON.stringify(content[index].userId) || 
                        JSON.stringify(content[index].id);
        var strBody = JSON.stringify(content[index].body);

        var tr = document.createElement("tr");
        var td1 = document.createElement("td");
        var td2 = document.createElement("td");
        var tdId = document.createTextNode(strUserId);
        var tdText = document.createTextNode(strBody);

        td1.appendChild(tdId);
        td2.appendChild(tdText);
        tr.appendChild(td1);
        tr.appendChild(td2);
        table.appendChild(tr);
    }
    return table;
}