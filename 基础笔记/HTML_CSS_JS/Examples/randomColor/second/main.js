main();


function main() {
    var div = document.querySelector(".whiteboard");
    
}

async function buttonPress() {
    repeatChangeColor();



    // div.style.color = color;
}


async function generateColor() {
    var hex = "0123456789ABCDEF";
    var result = "#";
    for (let i = 1; i < 7; i++){
        var index = Math.floor(Math.random() * 16);
        result += hex[index];
    }
    console.log(`result: ${result}`);
    return result;
}

async function repeatChangeColor() {
    var color = await generateColor();
    await changeColor(color);
    repeatChangeColor();
    return;
}


async function changeColor(color) {
    var div = document.querySelector(".whiteboard");
    div.style.backgroundColor = color;
    
    var p = new Promise( (resolve, reject)=> {
        var timer = setTimeout(() => {
            resolve();
        }, 500);
    });

    return p;
}   