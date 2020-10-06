class Employee {

    constructor(name, id) {
        this.name = name;
        this.id = id;
    }
    selfIntroduce() {
        console.log(`this is ${this.name}, id is ${this.id}`)
    }
    static goToMeeting(obj) {
        console.log(`${obj.name} is going to meeting`);
    }
}

let e = new Employee('tony', 11);
console.log(e);

class FullTime extends Employee {
    constructor(id, name, salary) {
        super(name, id);
        this.salary = salary;
    }
    selfIntroduceAndSalary() {
        super.selfIntroduce();
        console.log(`and my salary is ${this.salary}`);
    }
}

let f1 = new FullTime(1, "Darren", 4500);
f1.selfIntroduce();
console.log(f1.salary);
Employee.goToMeeting(f1);
f1.selfIntroduceAndSalary();


