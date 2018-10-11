





function delay(ms) {
    var p = new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve();
        }, ms);
    })
    return p;
}
console.log(`start\n`);

delay(3000).then(() => console.log('runs after 3 seconds'));