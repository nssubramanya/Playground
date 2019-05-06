const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question('Which fruit to buy?', (answer) => {
    console.log(`Answer:${answer}`);

    rl.close();
});