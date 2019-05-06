// // Import the express library here
// const express = require('express');
//
// // Instantiate the app
// const app = express();
//
// const PORT = 4001;
//
// console.log('Port Number ${PORT}');
//
// app.listen(PORT, ()=>{
//     console.log('Server is listening on port ${PORT}');
// });

const http = require('http');
const hostname = '127.0.0.1';
const port = 3000;

const server = http.createServer((req, res) => {
    res.statusCode = 200;
    res.setHeader('Content-Type', 'text/plain');
    res.end('Hello, World\n');
});

server.listen(port, hostname, () => {
    console.log('Server runnint at http://${hostname}:${port}/');
});
