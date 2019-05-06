var _ = require('lodash');
var yargs = require('yargs');
var notes = require('./notes');


const argv = yargs.argv;
var command = argv._[0];
console.log('Process:', process.argv);
console.log('Yargs:', argv);

switch (command){
    case 'add':
        notes.addNote(argv.title, argv.body);
        break;

    case 'list':
        notes.getAllNotes();
        break;

    case 'remove':
        notes.removeNote(argv.title);
        break;

    case 'read':
        debugger;
        notes.getNote(argv.title);
        break;

    default:
        console.log ('Command Not Recognized')
}
