import React from 'react';

const validator = (props) => {
    const successStyle = {
        color: "white",
        backgroundColor: "green"
    };

    const errorStyle = {
        color: "white",
        backgroundColor: "red"
    };

    return (
        <div>
            <p
                style={props.textLength >= 5 ? successStyle : errorStyle}
            >{props.textLength >= 5 ? "Text long enough!" : "Text too short!!!"}</p>
        </div>
    )
}
export default validator;