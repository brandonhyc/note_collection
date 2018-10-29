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
