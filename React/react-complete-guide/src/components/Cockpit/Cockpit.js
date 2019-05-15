import React from 'react';
import classes from "./cockpit.module.css"

const cockpit = (props) => {
  const assignedClasses = [];
  let btnClass = '';

  if (props.showPersons) {
    btnClass = classes.Red;
    // btnClass = "Red";
  }

  if (props.persons.length <= 2) {
    assignedClasses.push(classes.Red);
    // assignedClasses.push("Red");
  }

  if (props.persons.length <= 1) {
    assignedClasses.push(classes.Bold);
    // assignedClasses.push("Bold");
  }

  return (
    <div className={classes.Cockpit}>
      <h1>Hi, I'm a React App</h1>
      <p
        className={assignedClasses.join(' ')}>This is really working!</p>
      <button
        className={btnClass}
        onClick={props.clicked}>Toggle Persons</button>
    </div>

  )
}

export default cockpit;