

/** update time by using Date()
 */
(function () {
    setInterval(
        () => {
            document.querySelector("#now").textContent = (new Date()).toString();
        }, 1000)
})();


/** update time by using promise
 */
async function updateTime() {

    var promise = getNewTime();
    var time = await promise;
    document.querySelector("#clock").textContent = time;
    updateTime();
}

async function getNewTime() {

    var time = (new Date()).getTime();
    var sec = (time / 1000) % 60;
    var min = (time / (60 * 1000)) % 60;
    var hour = (time / (60 * 60 * 1000)) % 24;
    var day = (time / (24 * 60 * 60 * 1000)) % 30;
    var month = (time / (30 * 24 * 60 * 60 * 1000)) % 12;
    var year = Math.floor(time / (12 * 30 * 24 * 60 * 60 * 1000));

    var time = `${year} year, ${Math.floor(month)} month, 
                ${Math.floor(day)} day, ${Math.floor(hour)} hour, 
                ${Math.floor(min)} minute, ${Math.floor(sec)} second`;

    return new Promise((resolve) => {
        setTimeout(() => {
            resolve(time);
        }, 1000);
    })
    
}


function getTimeOnline() {
    var apiKey = "D18VSEKR2DXE";
    var url = 
    `http://api.timezonedb.com/v2.1/get-time-zone?key=${apiKey}format=json&by=zone&zone=America/Virginia`
    
    return fetch(url).then((response) => {
        console.log(response);
        return response.json();
    });
}

// getTimeOnline()
//     .then( (result) => {
//         console.log("this is the result: " + result);
//         var pTag = document.querySelector("#online")
//         pTag.textContent = result; 
//     })