function print(arr) {
    let index = 0;
    let newArray = [];
    while (index < arr.length - 1) {
        index = index + 2;
        newArray.push(arr[index]);
    }
    return newArray.reverse();

}

console.log(print([1,2,3,4]));