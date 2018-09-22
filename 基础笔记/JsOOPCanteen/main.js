/** 餐厅类
* 属性： 金钱， 座位数量、 职员列表
* 方法： 招聘职员， 解雇职员
*/

function Canteen(money, seats, staff) {
    this.money = money;
    this.seats = seats;
    this.staff = staff || [];
};

Canteen.prototype = {
    money: null,
    seats: null,
}

Canteen.prototype.hire = function (staff) {
    if (staff instanceof Staff) {
        console.log("hiring:", staff);
        this.staff.push(staff);
    } else {
        console.log("Failed to hire:", staff);
    }
    console.log("current staff array:", this.staff);
};
Canteen.prototype.fire = function (staff) {
    if (staff instanceof Staff) {
        let index = this.staff.indexOf(staff);
        if (index != -1) {  
            console.log("firing:", staff);
            this.staff.splice(index, 1);
        } else {
            console.log("Can't find:", staff);
        }
    } else {
        console.log("Failed to hire:", staff);        
    }
    console.log("current staff array:", this.staff);
};

/** 职员类
 * 属性： ID， 姓名， 工资
 * 方法： 完成一次工作
 */
function Staff(name, salary) {
    this.name = name;
    this.salary = salary;
    this.id = null;
}
Staff.prototype = {
    name : null,
    salary : null,
    id : null
}
Staff.prototype.work = function () {
    
}

/** 服务员类，继承自职员
* 完成一次工作：如果参数是个数组，则记录客人点菜，如果参数不是数组则是上菜行为
* 厨师类，继承自职员
* 完成一次工作：烹饪出菜品 
*/
function Waiter() {
    this.name = name;
    this.salary = salary;
}
var waiterProto = new Staff(null, null);

Waiter.prototype = waiterProto;
Waiter.prototype.constructor = function (name, salary) {
    this.name = name;
    this.salary = salary;
}

Waiter.prototype.work = function (item) {
    if (typeof item == 'object') {
        if (item.constructor == Array) {
            console.log("Waiter ordering food " + item);
        } else if (item instanceof Item) {
            console.log("Waiter serving food " + item.name);
        }
    } else {
        console.log("wrong input")
    }
}

function Cook(name, salary) {
    this.name = name;
    this.salary = salary;
}
var cookProto = new Staff(null, null);

Cook.prototype = cookProto;

Cook.prototype.work = function (item) {
    if (item instanceof Item) {
        console.log("cook done " + item);
    }
}

/**顾客类
 * 方法： 点菜， 吃
 */
function Customer() {
}
Customer.prototype.order = function (item) {
    if (item instanceof Item) {
        console.log("customer ordering " + item.name);

    }
    
}
Customer.prototype.eat = function (item) {
    if (item instanceof Item) {
        console.log("customer eating " + item.name);

    }

}

/** 菜品类
* 属性： 名字、 烹饪成本、 价格
*/
function Item(name, cookTime, price) {
    this.name = name;
    this.cookTime = cookTime;
    this.price = price;
}



var ifeRestaurant = new Canteen({
    cash: 1000000,
    seats: 20,
    staff: []
});

var newCook = new Cook("Tony", 10000);
ifeRestaurant.hire(newCook);

ifeRestaurant.fire(newCook);
console.log(ifeRestaurant.staff);