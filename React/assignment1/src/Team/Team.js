import React from 'react';

const team = (props) => {
    return (
        <div>
            <h3>{props.name} - {props.captain}</h3>
            {
                props.players.length ?
                    <p>Players: {props.players.join(', ')}</p>
                    : null
            }
        </div>
    )
}

export default team;
