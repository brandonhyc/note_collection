
/**
 * TODO: 
 * using promise count 4 time each time elapse 2 time 1,2,4,8
 * 
 * 
 */

function main() {
    var timeOne = document.querySelector(".timeOne");
    var timeTwo = document.querySelector(".timeTwo");
    var timeThree = document.querySelector(".timeThree");
    var timeFour = document.querySelector(".timeFour");

    generateTime()
        .then((sec) => {
            timeOne.textContent = sec;
            sec = parseInt(sec) + 2;
            return sec;
        }).then((sec) => {
            timeTwo.textContent = sec;
            
            return sec + 4;
        }).then((sec) => {
            timeThree.textContent = sec;
            return sec + 8;
        }).then((sec) => {
            timeFour.textContent = sec;
            return sec + 16;
        })
    
}

function generateTime() {
    var p = new Promise ((resolve, reject) => {
        resolve((new Date()).getSeconds());
    });
    return p;
}


function clickButton() {
    main();
}