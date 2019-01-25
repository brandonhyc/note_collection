let obj = {
    name: "parentObj",
    Child: {
        name: "childObj",
        callName: function () {
            console.log(this.name);
        }
    }
}
obj.Child.callName() // ?? ans: childObj

let func = obj.Child.callName;
// what will be a way to use callName() to have console result as “parentObj”

func.call(obj, null);
