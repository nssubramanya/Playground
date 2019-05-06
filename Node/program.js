// console.log(process.argv);

// for (i = 0; i < process.argv.length - 2; i++) {
//   arg = process.argv[i+2];
//   console.log (i + ': ' + arg + ' - ' + typeof(arg));
// }

var sum = 0;
for (i=2; i < process.argv.length; i++) {
  sum += Number(process.argv[i]);
}
console.log(sum);
