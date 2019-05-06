// Geocode with Promises
const request = require('request');

geocodeAddress = (address) => {
    return new Promise ((resolve, reject) => {
        var encodedAddress = encodeURIComponent(address);
        request({
            url: `https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyAtUVyYjtdrm18fWSj6LcQTihp4F4seq9o&address=${encodedAddress}`,
            json: true
        },(error, response, body)=>{
            // console.log(response);
            if (error) {
                reject('Unable to connect to google Servers.');
            }
            else if (body.status === 'ZERO_RESULTS'){
                // console.log(`Failed to geocode the address:`);
                reject(`Failed to geocode the address.`);
            } else if (body.status === 'OK'){
                resolve({
                    'address': body.results[0].formatted_address,
                    'lat': body.results[0].geometry.location.lat,
                    'long': body.results[0].geometry.location.lng
                });
            }
        });
    });
}

geocodeAddress(process.argv[2])
.then((result)=>{
    console.log(JSON.stringify(result, undefined, 2));
}, (errorMsg)=>{
    console.error(errorMsg);
});
