var fs = require('fs');

var filename = process.argv[2];
// console.log(filename);

try {
  content = fs.readFileSync (filename);
  content = content.toString().split('\n');

  // or
  // fs.readFileSync(filename, 'utf8').split('n');
  // console.log(content);
  console.log(content.length - 1);
}
catch(e) {
  console.log(e.name + ': ' + e.message);
}
finally {
  // console.log ('Finally');
}
