/*jshint esversion:6 */
var person = {
    name: "Subramanya",
    sayName: function () {
        console.log(this.name);
    }
};

person.sayName();

function sayNameForAll() {
    console.log(this.name);
}

var person1 = {
    name: 'Nicholas',
    sayName: sayNameForAll
};

var person2 = {
    name: 'Greg',
    sayName: sayNameForAll
};

var name = 'Michael';

person1.sayName();
person2.sayName();
sayNameForAll();

sayNameForAll.call(this, "global");
sayNameForAll.call(person1, 'person1');
sayNameForAll.call(person2, 'person2');

// Two ways to create objects
// Method 1: From Object Constructor

var person2 = new Object();
person2.name = 'Person2';


// Method 2: From Object Literal
var person3 = {
    name: 'Person3'
};

// Object Properties can be changed at any time unless prevented
person2.age = 50;
person3.age = 45;

console.log(person2, person3);

// Note: 
// When property is added first time, [[Put]] internal method is called
// when property value is changed, [[Set]] internal method is called

// Checking for existance of property values
console.log('name' in person1);
console.log('age' in person);
console.log('sayName' in person3);

person3.sayName = person.sayName;
console.log('sayName' in person3, person3.sayName());

// hasOwnProperty() is used to detect Own property vs Prototype Property
console.log(`Person2 has property 'age' : ${person2.hasOwnProperty('age')}`);

// Removing Properties - Calls [[Delete]] internal method
delete person3.sayName;
console.log('sayName' in person3);

// Enumerating Properties
console.log('Enumerating properties of person1')
for (let property in person1) {
    console.log('Name:', property, "Value", person1[property]);
}

let student = {
    name: 'Sushruth Subramanya',
    class: '7',
    section: 'B',
    school: 'RVK BSK'
};

var properties = Object.keys(student);
console.log(properties);

for (let i = 0, len = properties.length; i < len; i++) {
    console.log('Name: ', properties[i]);
    console.log('Value:', student[properties[i]]);
}

var student1 = {
    _name: 'Sushruth'
};
Object.defineProperty(student1, 'name', {
    get: function () {
        console.log('Reading name');
        return this._name;
    },
    set: function (value) {
        console.log('Setting name to %s', value);
        this._name = value;
    },
    enumerable: true,
    configurable: true
});

console.log('Student1', student1.name);
student1.name = 'Sushruth Subramanya';
console.log(student1._name);

Object.