const request = require('request');

module.exports.geocodeAddress = function (address, callback){
    var encodedAddress = encodeURIComponent(address);

    request({
        url: `https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyAtUVyYjtdrm18fWSj6LcQTihp4F4seq9o&address=${encodedAddress}`,
        // url: 'https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyAtUVyYjtdrm18fWSj6LcQTihp4F4seq9o&address=1006 22nd Main Road Jnanabharathi 2nd Block, Bangalore 560056',
        json: true
    }, (error, response, body) =>{
        if (error) {
            callback('Unable to connect to Google Servers.');
        } else if (body.status === 'ZERO_RESULTS'){
            callback('No Results.');
        } else if (body.status === 'OK'){
            // console.log(JSON.stringify(body, undefined, 2));
            // console.log(`Address: ${body.results[0].formatted_address}`);
            // console.log(`Latitude: ${body.results[0].geometry.location.lat}`);
            // console.log(`Longitude: ${body.results[0].geometry.location.lng}`);

            callback(undefined,  {
                'address': body.results[0].formatted_address,
                'lat': body.results[0].geometry.location.lat,
                'long': body.results[0].geometry.location.lng
            });
        }
    });
}
