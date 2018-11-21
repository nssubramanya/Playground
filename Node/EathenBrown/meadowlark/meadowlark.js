const express = require('express');
const fortunes = require('./fortunes');
const app = express();

const handlebars = require('express-handlebars').create({
    defaultLayout: 'main'
});
// Set View Engine
app.engine('handlebars', handlebars.engine);
app.set('view engine', 'handlebars');



// Try to take this from Configuration file later
app.set('port', process.env.PORT || 3000);
console.log(`Environment Setting: ${app.get('env')}`);

// Midleware - must be before we define routes
app.use(express.static(__dirname + '/public'));

app.use((req, res, next) => {
    res.locals.showTests = app.get('env') !== 'production' &&
        req.query.test === '1';
    next();
});


app.get('/', (req, res) => {
    // res.send('Hello, World\n');
    res.render('home');
});

app.get('/about', (req, res) => {
    // res.send('About Medialark Travel...\n');


    res.render('about', {
        fortune: fortunes.getFortune(),
        pageTestScript: '/qa/tests-about.js'
    });
});

// Middlewares
// custom 404 page
app.use((req, res) => {
    res.status(404);
    res.render('404');
});

// custom 500 page
app.use((err, req, res, next) => {
    console.error(err.stack);
    res.status(500);
    res.render('500');
});



app.listen(app.get('port'), () => {
    console.log(`Express started on http://localhost:` +
        app.get('port'));
});