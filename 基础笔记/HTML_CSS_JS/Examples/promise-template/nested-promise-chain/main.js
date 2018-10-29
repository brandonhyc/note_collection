function main() {
    var timeOne = document.querySelector(".timeOne");
    var timeTwo = document.querySelector(".timeTwo");
    var timeThree = document.querySelector(".timeThree");
    var timeFour = document.querySelector(".timeFour");

    generateTime()
        .then((sec)=>{
            timeOne.textContent = sec;

            var p = new Promise((resolve, reject) => {
                setTimeout(() => {
                    var time = parseInt((new Date()).getSeconds());
                    resolve(time);
                }, 1000);
            })
            return p;
        }).then((sec) => {
            timeTwo.textContent = sec;

            var p = new Promise((resolve, reject) => {
                setTimeout(() => {
                    var time = parseInt((new Date()).getSeconds());
                    resolve(time);
                }, 2000);
            })
            return p;
        }).then((sec) => {
            timeThree.textContent = sec;

            var p = new Promise((resolve, reject) => {
                setTimeout(() => {
                    var time = parseInt((new Date()).getSeconds());
                    resolve(time);
                }, 4000);
            })
            return p;
        }).then((sec) => {
            timeFour.textContent = sec;

            var p = new Promise((resolve, reject) => {
                setTimeout(() => {
                    var time = parseInt((new Date()).getSeconds());
                    resolve(time);
                }, 8000);
            })
            return p;
        })

}

function generateTime() {
    var p = new Promise((resolve, reject) => {
        var sec = parseInt((new Date()).getSeconds());
        resolve(sec);
    });
    return p;
}

function clickButton() {
    main();
}