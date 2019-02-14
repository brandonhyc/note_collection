function print(arr) {
    // let index = 0;
    // let newArray = [];
    // while (index < arr.length - 1) {
    //     newArray.push(arr[index]);
    //     index = index + 2;
    // }
    // return newArray.reverse();


var result = [];
for (var i = 0; i < arr.length; i = i + 2) {
    result.push(arr[i]);
}

return result.reverse();
}

console.log(print([1,2,3,4]));

can we jsut do not use size
size always equals to arr.length, just use 

the problem is, it use size that's wrong. arr.length