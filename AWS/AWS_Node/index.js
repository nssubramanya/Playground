var aws = require('aws-sdk');

// Create S3 Client
var s3 = new aws.S3();

var params = {};

s3.listBuckets(params, function (err, data) {
    if (err) {
        console.log(err, err.stack);
    } else {
        if (data.Buckets.length) {
            data.Buckets.forEach(bucket => {
                console.log(bucket);
            });
        }
    }
});