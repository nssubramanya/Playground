var aws = require('aws-sdk');
aws.config.update({
    region: 'us-east-1'
});

var ec2 = new aws.EC2();


var params = {};
var regions = null;
ec2.describeRegions(params, (err, data) => {
    if (err)
        console.log(err, err.stack);
    else {
        regions = data.Regions;
        regions.forEach((region) => {
            console.log("Region: " + region.RegionName + ' - ' + region.Endpoint);
            aws.config.region = region.RegionName;

            ec2.describeAvailabilityZones(params, (err, data) => {
                if (err)
                    console.log(err, err.stack);
                else
                    console.log(data);
            });
        });
        // console.log(regions);
    }


});