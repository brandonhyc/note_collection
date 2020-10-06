function addText() {
    var ul = document.querySelector("ul");
    var li = document.createElement("li");
    
    var text = document.querySelector("input[type='text']").value;
    var textNode = document.createTextNode(text);
    li.appendChild(textNode);
    ul.appendChild(li);
}


function remove(event) {
    var t = event.target;
    var text = t.textContent;
    console.log(text);
    var list = document.querySelectorAll("ul li");
    for (let li of list) {
        if (li === t) {
            li.parentElement.removeChild(li);
        }
    }
}

