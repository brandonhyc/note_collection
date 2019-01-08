const str = `ab;cd`
var result = str.split(";")[1];
console.log(result);




// var one = 0;
// var zero = 1;
// var foo = [];
// for (let i = 0; i < 10; i++) {
//     foo[i] = function () {
//         console.log(i)
//     };
// }

// for (var time = 0; time < 10; time++) {
//     foo[time]();
// }


// function adderGenerator(a, b) {
//     var sum = a;
//     var step = b;
//     return function () {
//         sum += step; 
//         return sum;
//     }
// }

// var adderA = adderGenerator(10, 2);

// for (var time = 0; time < 10; time++) {
//     console.log(adderA());
// }