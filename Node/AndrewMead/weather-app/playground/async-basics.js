console.log('Starting App');

var x = 1;
var y = x + 9;

console.log(`y is ${y}`);

setTimeout(()=>{
    console.log('Inside a callback');
}, 2000);

setTimeout(() => {
    console.log('Second Timout Works');
}, 0);

console.log('Finishing Up');
