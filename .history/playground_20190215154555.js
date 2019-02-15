function countSteps (binary) {
    let decimal = parseInt(binary, 2);
    let step = 1;
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

console.log(countSteps("0111000"));

