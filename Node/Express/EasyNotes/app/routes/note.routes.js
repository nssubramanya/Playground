/*jshint esversion:6*/
module.exports = (app) => {
    const notes = require('../controllers/note.controller');

    // Create a new Note
    app.post('/notes', notes.create);

    // Retrieve all Notes
    app.get('/notes', notes.findAll);

    // Retrieve single note with Note Id
    app.get('/notes/:noteId', notes.findOne);

    // Update a note with Note Id
    app.put('/notes/:noteId', notes.update);

    // Delete Note
    app.delete('/notes/:noteId', notes.delete);
}