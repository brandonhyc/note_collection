function buttonPress3() {
    setLocalStorage();
}

async function buttonPress4() {
    var item = await getLocalStorage();
    var whiteBoard = document.querySelector("#display");
    whiteBoard.textContent = item;  
}

function getLocalStorage() {
    var result = localStorage.getItem("uname");
    return new Promise( (resolve, resject) => {
        resolve(result);
    })
}

function setLocalStorage() {
    var item = prompt("set your localStorage");
    localStorage.setItem("uname", item);
}

function buttonPress1() {
    setCookie();
}

async function buttonPress2() {
    var cookieObject = await getCookie();
    var whiteBoard = document.querySelector("#display");
    whiteBoard.textContent = JSON.stringify(cookieObject);
}

function setCookie() {
    var cookie = prompt("set your cookie");
    document.cookie= "uname=" + cookie;
}

async function getCookie() {
    var cookie = document.cookie;
    var cookieArray = cookie.split(";");
    var cookieObject = {};

    for (let pair of cookieArray) {
        var key = pair.split("=")[0];
        var value = pair.split("=")[1];
        cookieObject[key] = value;
    }

    return cookieObject;
}