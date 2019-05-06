function Person(name) {
    this.name = name;
    this.sayName = function () {
        console.log(this.name);
    }
    // intentionally empty
}

var person1 = new Person('Sushruth');
var person2 = new Person('Subramanya');

console.log(person2 instanceof Person);

person1.sayName();
person2.sayName();

function Student(name) {
    Object.defineProperty(this, "name", {
        get: function () {
            return name;
        },
        set: function (newName) {
            name = newName;
        },
        enumerable: true,
        configurable: true
    });

    this.sayName = function () {
        console.log(this.name);
    }
}

var s1 = new Student('Roopashree');
s1.sayName();

var o = new Object();
o.