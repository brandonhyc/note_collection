main();

async function main() {

    updateTimer();
    updateDate();
}

async function updateDate() {
    var time = await getDate();
    var p = document.querySelector(".date");
    p.innerHTML = time;

    await setTimeout( () => {
        updateDate();
    }, 1000)
}

async function getDate() {

    var date = new Date();
    var time = date.getTime();

    var sec = Math.floor((time / 1000) % 60); // 61 % 60 = 1sec
    var min = Math.floor((time / 1000 / 60) % 60);
    var hour = Math.floor((time / 1000 / 60 / 60) % 24);
    var day = Math.floor((time / 1000 / 60 / 60 / 24) % 30);
    var mon = Math.floor((time / 1000 / 60 / 60 / 24 / 30) % 12);
    var year = Math.floor((time / 1000 / 60 / 60 / 24 / 30 / 12));
    
    var time = `year ${year}, mon ${mon}, day ${day}, hour ${hour}, min ${min}, sec ${sec}`
    console.log("time: ", time);

    return time;
}


function updateTimer() {
    var p = document.querySelector(".timer");

    var date = new Date();
    p.innerHTML = date;
    
    setTimeout(function() {
        updateTimer();
    } , 1000);
    
}