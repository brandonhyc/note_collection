"use strict"
function colorButton() {
    changeColor(".color");
}

/**
 * change color
 */

async function changeColor(divSelector) {
    var div = document.querySelector(divSelector);
    var color = await generateRandomColor();
    
    div.style.backgroundColor = color;
}


/** 
 * output: string color
 */
async function generateRandomColor() {

    let promise = new Promise((resolve, reject) => {
        setTimeout(() => {
            var color = "#";
            var hex = "0123456789ABCDEF";

            for (let i = 1; i < 7; i++) {
                color += hex[Math.floor(Math.random() * 16)];
            }
            resolve(color);
        }, 1000);
    }
)
    return await promise;
}