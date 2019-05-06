/*jshint esversion:6*/
const express = require('express');
const bodyParser = require('body-parser');
const port = process.env.port || 3000;

const app = express();

// Modules
// parse requests of content-type: application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({
    extended: true
}));

// parse requests of content-type: application/json
app.use(bodyParser.json());

// Configuring the database
const dbConfig = require('./config/database.config');
const mongoose = require('mongoose');

mongoose.Promise = global.Promise;

// Connect to Database
mongoose.connect(dbConfig.url, {
    useNewUrlParser: true
}).then(() => {
    console.log('Successfully connected to the database');
}).catch((err) => {
    console.log('Could not connect to Database. Exiting now...', err);
    process.exit();
});

app.get('/', (req, res) => {
    res.json({
        message: "Welcome to EasyNotes application. Take Notes quickly."
    });
});

// Require Notes Routes
require('./app/routes/note.routes')(app);

app.listen(port, () => {
    console.log(`Server started successfully on port ${port}`);
});