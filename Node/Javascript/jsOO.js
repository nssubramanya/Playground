/*jshint esversion:6 */

function Person(name, age) {
    this.name = name;
    this.age = age;
}

Person.prototype.sayName = function () {
    console.log(`${this.name} is ${this.age} years old.`);
};

// Person.prototype.favorites = [];


var p1 = new Person('Sushruth', 12);
var p2 = new Person('Roopashree', 39);
// p1.favorites.push("Pizza");
// p2.favorites.push('Apple Cake');

p1.sayName();
p2.sayName();

function Rectangle(length, width) {
    this.length = length;
    this.width = width;
}

Rectangle.prototype.getArea = function () {
    return this.length * this.width;
};

Rectangle.prototype.toString = function () {
    return (`[Rectangle: ${this.length} x ${this.width}]`);
};

function Square(size) {
    this.length = size;
    this.width = size;
}

Square.prototype = new Rectangle();
Square.prototype.constructor = Square;

Square.prototype.toString = function () {
    return (`[Square: ${this.length} x ${this.width}]`);
};

var rect = new Rectangle(5, 10);
var square = new Square(15);

console.log(rect.getArea(), rect.toString());
console.log(square.getArea(), square.toString());