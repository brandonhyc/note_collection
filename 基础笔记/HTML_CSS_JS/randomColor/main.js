var list = document.querySelectorAll("td");
var timer; 

function stopColorTimer() {
    if (timer) {
        clearInterval(timer);
    }

}

function setColorTimer() {
    timer = setInterval(() => {
        changeColor();
    }, 1000);

}

function changeColor() {    
    for (let td of list) {
        td.style.backgroundColor = getRandomColor();
    }
}
function getRandomColor() {
    var hex = "0123456789ABCDEF";
    var strColor = "#";
    for (let i = 1; i < 7; i++) {
        strColor += hex[Math.floor(Math.random() * 16)];
    }
    return strColor;
}