var fs = require('fs');
var path = require('path');

module.exports = function (dir, ext, callback){
    // console.log('Filtering files %s %s', dir, ext);
    var extension = '.' + ext;
    var fileList = [];

    fs.readdir(dir, (err, files) => {
        if(err){
            return callback(err);
        }

        // console.log(files);
        files.forEach((file) => {
            if(path.extname(file) === extension){
                // console.log(file);
                fileList.push(file);
            }
        });

        // fileList = fileList.filter((file) => {
        //     return path.extname(file) == extension;
        // });
        // console.log(fileList);
        return callback(err, fileList);
    });
}
