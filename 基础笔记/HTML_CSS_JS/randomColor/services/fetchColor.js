function getRandomColor() {
    var hex = "0123456789ABCDEF";
    var strColor = "#";
    for (let i = 1; i < 7; i++) {
        strColor += hex[Math.floor(Math.random() * 16)];
    }
    var p = new Promise((resolve, reject) => {
        if (flag) {
            resolve(strColor);
        } else {
            reject(new Error("button pressed"));
        }
    });
    return p;
}