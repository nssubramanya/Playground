/*jshint esversion:6*/
const Note = require('../models/note.model');

// Create and Save a new Note
exports.create = (req, res) => {
    // Validate Request
    if (!req.body.content) {
        return res.status(400).send({
            message: 'Note content cannot be empty'
        });
    }

    // Create a note
    const note = new Note({
        title: req.body.title || 'Untitled Note',
        content: req.body.content
    });

    // Save Note in the database
    note.save()
        .then((data) => {
            res.send(data);
        }).catch((err) => {
            res.status(500).send({
                message: err.message || 'Some error occurred while creating the Note'
            });
        });
};

exports.findAll = (req, res) => {
    Note.find()
        .then(notes => {
            res.send(notes);
        }).catch(err => {
            res.status(500).send({
                message: err.message || 'Some Error occurred in retrieving notes'
            });
        });
};

exports.findOne = (req, res) => {
    Note.findById(req.params.noteId)
        .then(note => {
            if (!note) {
                return res.status(404).send({
                    message: 'Note not found with id' + req.params.noteId
                });
            }
            res.send(note);
        }).catch(err => {
            if (err.kind === 'ObjectId') {
                return res.status(404).send({
                    message: 'Note not found with Id: ' + req.params.noteId
                });
            }
            return res.status(500).send({
                message: 'Error Retrieving Note with Id: ' + req.params.noteId
            });
        });
};

exports.update = (req, res) => {
    // Validate Request
    if (!req.body.content) {
        return res.status(400).send({
            message: 'Note content cannot be empty'
        });
    }

    // Find Note and update it with request body
    Note.findByIdAndUpdate(req.params.noteId, {
            title: req.body.title || 'Untitled Note',
            content: req.body.content
        }, {
            new: true
        })
        .then(note => {
            if (!note) {
                return res.status(404).send({
                    message: 'Note not found with ID: ' + req.params.noteId
                });
            }
            res.send(note);
        }).catch(err => {
            if (err.kind == 'ObjectId') {
                return res.status(404).send({
                    message: 'Note not found with id: ' + req.params.noteId
                });
            }

            return res.status(500).send({
                message: 'Error updating note with id: ' + req.params.noteId
            });
        });
};


exports.delete = (req, res) => {
    Note.findByIdAndRemove(req.params.noteId)
        .then(note => {
            if (!note) {
                return res.status(404).send({
                    message: 'Note not found with id: ' + req.params.noteId
                });
            }
            res.send({
                message: 'Note deleted successfully!'
            });
        }).catch(err => {
            if (err.kind === 'ObjectId' || err.name == 'NotFound') {
                return res.status(404).send({
                    message: 'Note not found with id ' + req.params.noteId
                });
            }

            return res.status(500).send({
                message: 'Could not delete note with id: ' + req.params.noteId
            });
        });
};