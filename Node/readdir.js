var fs = require('fs');
var path = require('path');

dirname = process.argv[2];
extn = process.argv[3]

// Synchronous Read
// files = fs.readdirSync(dirname);

fs.readdir(dirname, (err, files) => {
    if (err) throw err;
    showFiles(files);
});

function showFiles (files) {
    // console.log(files);
    for (i=0; i<files.length;i++) {
        // console.log(files[i].split('.'));
        if (path.extname(files[i]).split('.')[1] === extn) {
            console.log(files[i])
        }
    }
}
