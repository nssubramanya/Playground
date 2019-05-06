var addNote = (title, body) => {
    console.log('Adding Note:', title, body);
};

var getAllNotes = (title) => {
    console.log('Get All Notes');
};

var getNote = (title) => {
    console.log('Get Note: ', title)
};

var removeNote = (title) => {
    console.log('Remove Note:', title);
};

module.exports = {
    addNote,
    getNote,
    getAllNotes,
    removeNote
};
