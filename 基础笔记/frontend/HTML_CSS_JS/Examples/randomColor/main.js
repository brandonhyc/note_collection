var list = document.querySelectorAll("td");
var timer;
var flag = true;

function onClickStart() {
    var p = getRandomColor();

    p.then((result) => {
        changeColor(result);
    }).then(() => {
        setTimeout(() => {
            onClickStart();
        }, 500);
    }).catch((e) => {
        alert(e);
    })
}

function stopColorTimer() {
    flag = false;
}

function setColorTimer() {
    timer = setTimeout(() => {
        changeColor();
    }, 1000);
}

function changeColor(color) {    
    for (let td of list) {
        td.style.backgroundColor = color;
    }
}
function getRandomColor() {
    var hex = "0123456789ABCDEF";
    var strColor = "#";
    for (let i = 1; i < 7; i++) {
        strColor += hex[Math.floor(Math.random() * 16)];
    }
    var p = new Promise((resolve, reject) => {
        if (flag) {
            resolve(strColor);
        } else {
            reject(new Error("button pressed"));
        }
    });
    return p;
}

function getRandom8Digits() {
    var decimal = "0123456789"
    var number = "";
    for (let i = 0; i < 8; i++) {
        number += decimal[Math.floor(Math.random() * 10)];
    }
    return number;
}