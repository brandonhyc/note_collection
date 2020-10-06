// 1. for array/string
const number = [1,2,3];
const str = "string";

console.log([...number, 4, 5]);
console.log([...'ne', 'w' , ...str]);


// 2. for rest parameters
function isFullAge6(age, ...years) {
    years.forEach(cur => console.log((2016 - cur) >= age));
    years.forEach(cur => console.log(cur));
    return years;
}
isFullAge6(18, 1990, 1999, 1965, 2016, 1987);
console.log('isFullAge6(1990, 1999, 1965, 2016, 1987): ', 
            isFullAge6(1990, 1999, 1965, 2016, 1987));
// true, false, true, false, ....
// 1990, 1999, 1965, 2016, 1987
// return (5) [1990, 1999, 1965, 2016, 1987]