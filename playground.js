// const case1 = "00-44   48 5555 8361";
// const ans1 = "004-448-555-583-61";

// console.log(formatPhoneNumber(case1));

function formatPhoneNumber(str) {
    str = strip(str);
    
    let result = "";
    let start = 0;


    while(start < str.length) {
        if (start + 2 >= str.length) {
            result += str.slice(start, str.length);
            return result;
        }

        result += str.slice(start, start + 2);
        result += "-";
        
        start += 2;
    }
    

    function strip(str) {
        return str.replace(/[^\d]/g, '');
    }
}




function outer() {
    var number = 0;    
    
    return function () {
        return number++;
    }
}

getNumber = outer();
for (let i = 0; i < 2; i++) {
    console.log(getNumber());
}
