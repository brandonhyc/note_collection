function main() {
    var timeOne = document.querySelector(".timeOne");
    var timeTwo = document.querySelector(".timeTwo");
    var timeThree = document.querySelector(".timeThree");
    var timeFour = document.querySelector(".timeFour");

    generateTime()
        .then(null, (sec)=>{
            timeOne.textContent = sec;

            var p = new Promise((resolve, reject) => {
                setTimeout(() => {
                    
                    reject("rejected 1");
                }, 1000);
            })
            return p;
        }).then(null, (sec) => {
            timeTwo.textContent = sec;

            var p = new Promise((resolve, reject) => {
                setTimeout(() => {
                    reject("rejected 2");

                }, 2000);
            })
            return p;
        }).then(null, (sec) => {
            timeThree.textContent = sec;

            var p = new Promise((resolve, reject) => {
                setTimeout(() => {
                    reject("rejected 3");

                }, 4000);
            })
            return p;
        }).then(null, (sec) => {
            timeFour.textContent = sec;

            var p = new Promise((resolve, reject) => {
                setTimeout(() => {
                    reject("rejected 4");

                }, 8000);
            })
            return p;
        })
    }

function generateTime() {
    var p = new Promise((resolve, reject) => {
        var sec = parseInt((new Date()).getSeconds());
        reject(sec);
    });
    return p;
}

function clickButton() {
    main();
}