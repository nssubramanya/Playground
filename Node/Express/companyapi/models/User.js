const mongoose = require('mongoose');

var UserSchema = new mongoose.Schema({
    userName: String,
    email: String,
    bio: String,
    image: String,
    hash: String,
    salt: String
}, {timestamps: true});

mongoose.model('User', UserSchema);