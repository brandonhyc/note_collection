(function () {
    setInterval(
        () => {
            document.querySelector("#now").textContent = (new Date()).toString();
        }, 1000)
})();

var time = (new Date()).getTime();

var sec = Math.floor(time / 1000);
var min = Math.floor(sec / 60);
var hour = Math.floor(min / 60);
var day = Math.floor(hour / 24);
var month = Math.floor(day / 30);
var year = Math.floor(month / 12);

document.querySelector("#clock").textContent = 
    `${year} year, ${month} month, ${day} day, ${hour}, ${min} minute, ${sec} second`