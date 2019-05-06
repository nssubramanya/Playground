// Writing to console
// ===================
// console.log("HELLO WORLD");
// var name = 'Subbu', age=42, height=55;
// console.log("Hello %s. Your age is %d and your Height in Feet is: %f", name, age, height/12);

// Handling Command Line Arguments
// ================================
// console.log("Node Path: %s", process.argv[0]);
// console.log("Program Path: %s", process.argv[1]);
// for (i=2; i < process.argv.length; i++)
//     console.log("Arg %d: %s", i, process.argv[i]);

// Synchronous File I/O
// =====================
// var fs = require('fs');
// // var buffer = fs.readFileSync('test.txt');
// var buffer = fs.readFileSync(process.argv[2]);
// var str = buffer.toString();
// str = str.split('\n');
// console.log(str.length-1);
//
// // Single Line Solution
// // var lines = fs.readFileSync(process.argv[2], 'utf8').split('\n').length -1;

// Asynchronous File I/O
// =======================
// var fs = require('fs');
// fs.readFile(process.argv[2], 'utf8', (err, data) => {
//     if (err){
//         return console.log(err);
//     }
//     var lines = data.split('\n').length - 1;
//     console.log(lines);
// });

// Asynchronous Read Directory contents
// =====================================
// var fs = require('fs');
// var path = require('path');
//
// var dir = process.argv[2], ext = '.' + process.argv[3];
//
// fs.readdir(dir, (err, files) => {
//     if (err) return console.log(err);
//
//     files.forEach((file) => {
//         if(path.extname(file) === ext)
//             console.log(file);
//     });
// });

// Using Custom Modules
// ====================
// var mymodule = require('./mymodule.js');
// mymodule(process.argv[2], process.argv[3], (err, matchingFiles) => {
//     if (err){
//         return console.error('There was an error: ', err);
//     }
//
//     matchingFiles.forEach((file) => {
//         console.log(file);
//     });
// });

// Using HTTP Library - get ()
// ============================
// var http = require('http');
// http.get(process.argv[2], (response) => {
//     response.setEncoding('utf8');
//     response.on('data', console.log);
//     response.on('error', console.error);
// }).on('error', console.error);

// Collect HTTP data - Method 1
// =================================
// var http = require('http');
// http.get(process.argv[2], (res) => {
//     res.setEncoding('utf8');
//     let rawData = '';
//     res.on('data', (chunk) => {rawData += chunk;});
//     res.on('end', () => {
//         console.log(rawData.length);
//         console.log(rawData);
//     });
//     res.on('error', console.error);
// }).on('error', console.error);

// Collect HTTP Data - Method 2 (Using bl - Buffer List)
// ====================================================
// var http = require('http');
// var bl = require('bl');
// http.get(process.argv[2], (response) => {
//     response.pipe(bl((err, data) => {
//         if (err){

//             return console.error(err);
//         }
//         data = data.toString();
//         console.log(data.length);
//         console.log(data);
//     }));
// });

// Juggling Async - Manually
// ==========================
// var http = require('http');
// var bl = require('bl');
// http.get(process.argv[2], (res1) => {
//     res1.pipe(bl((err, data) => {
//         if (err) return console.error(err);
//         data = data.toString();
//         console.log(data);
//
//         http.get(process.argv[3], (res2) => {
//             res2.pipe(bl((err, data) => {
//                 if (err) return console.error(err);
//                 data = data.toString();
//                 console.log(data);
//
//                 http.get(process.argv[4], (res3) => {
//                     res3.pipe(bl((err, data) => {
//                         data = data.toString();
//                         console.log(data);
//                     }));
//                 });
//             }));
//         });
//     }));
// });

// Juggling Async

// var http = require('http')
// var bl = require('bl')
// var results = []
// var count = 0
//
// function printResults() {
//     for (var i = 0; i < 3; i++) {
//
//         console.log(results[i])
//     }
// }
//
// function httpGet(index) {
//     http.get(process.argv[2 + index], function(response) {
//         response.pipe(bl(function(err, data) {
//             if (err) {
//                 return console.error(err)
//             }
//
//             results[index] = data.toString()
//             count++
//
//             if (count === 3) {
//                 printResults()
//             }
//         }))
//     })
// }
//
// for (var i = 0; i < 3; i++) {
//     httpGet(i)
// }
