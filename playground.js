function sum(a) {
    
    let currentSum = a;

    const func = function f(b) {
        currentSum += b;
        return f;
    }

    func.toString = function() {
        return currentSum;
    } 

    return func;
}
console.log(sum(1)(2) == 3);
sum(1)(2)(3) == 6; // 1 + 2 + 3
sum(5)(-1)(2) == 6
sum(6)(-1)(-2)(-3) == 0
sum(0)(1)(2)(3)(4)(5) == 15