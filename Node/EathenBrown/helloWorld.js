const http = require('http');
const port = 3000;

http.createServer((req, res) => {
    // normalize url
    var path = req.url.replace(/\/?(?:\?.*)?$/, '').toLowerCase();
    console.log(`${req.url}, ${path}`);
    switch (path) {
        case '':
    }
}).listen(3000);

console.log('Server started on localhost:3000');
// http: //localhost:3000/products/?name=Subbu&age=42