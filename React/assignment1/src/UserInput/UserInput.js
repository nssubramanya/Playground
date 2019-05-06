import React from 'react';

const userInput = () => {
    return (
        <div>
            <input type="text" placeholder="Enter Team Name" />
            <input type="text" placeholder="Enter Captain" />
            <input type="text" placeholder="Players" />
            <button type="button">Submit</button>
        </div>
    )
}

export default userInput;