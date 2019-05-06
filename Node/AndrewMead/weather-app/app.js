// const yargs = require('yargs');
// const geocode = require('./geocode/geocode');
//
// const argv = yargs
//     .options({
//         a:{
//             demand: true,
//             string: true,
//             alias: 'address',
//             describe: 'Address to fetch weather for'
//         }
//     })
//     .help()
//     .alias('help', 'h')
//     .argv;
//
// geocode.geocodeAddress(argv.address, (errorMsg, coordinates) => {
//     console.log('Printing in Main Function...');
//     if (errorMsg){
//         console.log(errorMessage);
//     } else{
//         console.log(`Address: ${coordinates.address}\nLatitude: ${coordinates.lat}\nLongitude: ${coordinates.long}`);
//     }
// });

// Darksky API Key: c1d4564a95606217c32b69c3a8e331f3
// https://api.darksky.net/forecast/c1d4564a95606217c32b69c3a8e331f3/37.8267,-122.4233

const request = require('request');
request({
    url: 'https://api.darksky.net/forecast/c1d4564a95606217c32b69c3a8e331f3/12.9392297,77.5533562',
    json: true
}, (error, response, body) => {
    console.log(body.currently.temperature);

    // console.log(error);
    // console.log(response);

    // if (error) {
    //     console.error(error);
    // } else if (responseelse if (body.status === 'OK'){
    //     console.log(`Temperature: ${body.currently.temperature}`)
    // }
});
