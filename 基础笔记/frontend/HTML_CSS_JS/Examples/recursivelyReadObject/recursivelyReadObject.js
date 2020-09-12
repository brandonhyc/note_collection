let company = {
    sales: [{
        name: 'John',
        salary: 1000
    }, {
        name: 'Alice',
        salary: 600
    }],

    development: {
        sites: [{
            name: 'Peter',
            salary: 2000
        }, {
            name: 'Alex',
            salary: 1800
        }],

        internals: [{
            name: 'Jack',
            salary: 1300
        }]
    }
};

console.log(sumOfSalary(company));


function sumOfSalary(department) {
    if (Array.isArray(department)) {
        return department.reduce((a, b) => a + b.salary, 0);
    }

    let sum = 0;
    for (let sub of Object.values(department)) {
        sum += sumOfSalary(sub);
    }

    return sum;
}