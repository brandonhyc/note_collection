function countSteps (binary) {
    let decimal = parseInt(binary, 2);
    let step = 0;
    while (decimal != 0) {
        console.log(`step:${step}, decimal is: ${decimal}`)
        step++;
        if (decimal % 2 != 0) {
            decimal = decimal - 1;
        } else {
            decimal = decimal / 2;
        }
    }
    return step;
}

console.log(countSteps("011100"));

11100
7

1 1110
2 111
3 110
4 11
5 10
6 1
7 0

function countStep (binary) {
    let step = 0;
    let isPrefix = true;
    for (let index = 0; binary.length; index++) {
        let c = binary.charAt(index);
        if (c == 0 && isPrefix) {
            continue;
        }
        isPrefix = false;
        
        if (binary.charAt(index) == 1) {
            step++;
            continue;
        } 
        else if (binary.charAt(index) == 0) {
            step = step + 2;
            continue;
        }
    }
}