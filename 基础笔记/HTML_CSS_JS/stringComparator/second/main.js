function buttonPress() {

    var str1 = prompt("1");
    var str2 = prompt("2");
    
    var stringArray = str1.split("");

    for (let index in stringArray) {
        console.log(index);
        
        if (str2.indexOf(stringArray[index]) !== -1) {
            stringArray[index] = "_";
        }
    }

    document.querySelector("#whiteboard").textContent = 
        stringArray.join("");
}