var isCapturing = true;

document.querySelector("div.capturing").addEventListener("click", clickDiv, isCapturing);
document.querySelector("div.capturing form").addEventListener("click", clickForm, isCapturing);
document.querySelector("div.capturing form input").addEventListener("click", clickButton, isCapturing);

document.querySelector("div.prevent").addEventListener("click", clickDiv, !isCapturing);
document.querySelector("div.prevent form").addEventListener("click", clickForm, !isCapturing);
document.querySelector("div.prevent form input").addEventListener("click", clickButton, !isCapturing);

function clickDiv() {
    alert('DIV');
}

function clickForm() {
    alert('FORM');

}

function clickButton() {
    alert('BUTTON');
}

