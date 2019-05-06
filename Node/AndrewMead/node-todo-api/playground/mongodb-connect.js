const MongoClient = require('mongodb').MongoClient;

MongoClient.connect('mongodb://localhost:27017/TodoApp', (err, db) =>{
    if (err) {
        return console.log('Unable to connect to Mongodb Server')
    }

    console.log('Connected to Mongodb Server');

    db.close();
});
