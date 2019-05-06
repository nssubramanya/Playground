var fs = require('fs');

var filename = process.argv[2];
// console.log(filename);

try {
  content = fs.readFile (filename, {encoding: 'utf8'}, (err, data) => {
    if (err) throw err;
    console.log (data.split('\n').length - 1)
  });
}
catch(e) {
  console.log(e.name + ': ' + e.message);
}
finally {
  // console.log ('Finally');
}
