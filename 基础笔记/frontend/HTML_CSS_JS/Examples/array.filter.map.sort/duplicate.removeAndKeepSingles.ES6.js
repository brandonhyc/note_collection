let str = "aabbceed";
// 1.return "cd" (remove all depulicates)
// 2. not using if or :

function removeDuplicates(str) {
    let arr = [...str];
    let allDuplicates = arr.filter((el) => arr.indexOf(el) != arr.lastIndexOf(el), arr);
    return arr.filter((el) => allDuplicates.indexOf(el) === -1);            
}

console.log(removeDuplicates(str));