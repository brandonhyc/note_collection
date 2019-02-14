let stack = new Stack();
lines.forEach(element => {
    stack.push(element);
});

问题是，他本身程序没调push和pop函数
你知道什么是alternate integer 吗

let index = 0;

while (index < arr.length -1 ) {
    index = index + 2;
    newArray.push(arr[index]);
}
return newArray