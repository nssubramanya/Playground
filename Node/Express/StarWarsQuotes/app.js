const express = require('express')
const bodyParser = require('body-parser')
const MongoClient = require('mongodb').MongoClient;

const hbs = require('hbs')

const app = express()
const port = process.env.PORT || 3000


// Configuration
app.set('view engine', 'hbs')

// Middleware
app.use(bodyParser.urlencoded({ extended: true }))

// Handlers
app.get('/', (req, res) => {
    var cursor = db.collection('quotes')
        .find()
        .toArray((err, results) => {
            res.render('index.hbs', { show_quotes: results })
            console.log(results);
        });
    // res.render('index.hbs', {
    //     show_quotes: [{
    //         author: 'Vivekananda',
    //         quote: 'Arise, Awake'
    //     }, {
    //         author: 'Gandhi',
    //         quote: 'Be the man'
    //     }]
    // });
})

app.post('/quotes', (req, res) => {
    db.collection('quotes').insertOne(req.body, (err, result) => {
        if (err) return console.log(err);
    })
    console.log(`Saved to Database: ${req.body}`);
    res.redirect('/');
})

app.delete('/quotes/{:id}', (req, res) => {

});

let db
let mongoPath = 'mongodb://localhost:27017/starwars';
MongoClient.connect(mongoPath, (err, client) => {
    if (err) {
        console.dir(err);
    }
    console.log('Successfully connected to Database');

    db = client.db('starwars')

    app.listen(port, () => {
        console.log(`Application successfully started on ${port}`)
    })
})




