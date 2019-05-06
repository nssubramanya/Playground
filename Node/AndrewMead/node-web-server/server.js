const express = require('express');
const hbs = require('hbs');

var app = express();

app.set('view engine', 'hbs');
app.use(express.static(__dirname + '/public'));

app.get('/', (req, res) => {
    // res.send('<h1>Hello Express</h1>');
});

app.get('/about', (req, res) => {
    // res.send('About Page');
    res.render('aboutus.hbs', {
        companyName: 'Anveshi Technologies Pvt. Ltd.',
        copyrightYear: new Date().getFullYear()
    });
});

app.listen(8080, () => {
    console.log('Server is up on port 8080')
});
