var getUser = (id, callback) => {
    var user = {
        id: 5,
        name: 'Andrew'
    };

    setTimeout(()=>{
        callback(user);
    }, 3000);
};

getUser (5, (user)=>{
    console.log(user);
});
