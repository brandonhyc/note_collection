function countSteps (binary) {
    let decimal = parseInt(binary, 2);
    let step = 0;
    while (decimal != 0) {
        step++;
        if (decimal % 2 != 0) {
            decimal = decimal - 1;
        } else {
            decimal = decimal / 2;
        }
    }
    return step;
}

console.log(countSteps("0111000"));

