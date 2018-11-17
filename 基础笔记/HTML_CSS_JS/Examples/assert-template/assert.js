function assert(value, desc, testName) {
    var li = document.createElement("li");

    var ul = document.querySelector("#" + testName) || 
             document.querySelector("#result") || 
             createUl();
    var desc = document.createTextNode(desc);

    li.appendChild(desc);
    li.style.color = (value) ? "green" : "red"; 

    ul.appendChild(li);
}


function test(testIdName, fn) {

    var ul = document.querySelector("#result") || 
             createUl();

    debugger
    var test = document.createElement("ul");
    test.textContent = `${testIdName}  - - - - - - - - - - - - - - - - -`;
    test.id = testIdName;
    ul.appendChild(test);

    fn(testIdName);
    
}

function createUl(){

    ul = document.createElement("ul");
    ul.id = "result";
    document.body.appendChild(ul);
    ul.style.border = "thick solid black";
    ul.style.backgroundColor = "#FFB734"
    
    return ul;
}