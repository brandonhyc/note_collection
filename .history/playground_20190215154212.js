function countSteps (binary) {
    let decimal = parseInt(binary, 2);

    while (decimal != 0) {
        if (decimal % 2 != 0) {
            decimal = decimal - 1;
        } else {
            decimal = decimal / 2;
        }
    }

}

