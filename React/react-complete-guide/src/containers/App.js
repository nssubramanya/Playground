import React, { Component } from 'react';
import styles from "./app.module.css";
// import Radium from 'radium';
import Cockpit from "../components/Cockpit/Cockpit";
import Persons from '../components/Persons/Persons';

// import Person from './Person/Person';

class App extends Component {
  state = {
    persons: [
      { id: 1, name: "Max", age: 28 },
      { id: 2, name: "Manu", age: 29 },
      { id: 3, name: "Steve", age: 26 }
    ],
    showPersons: false
  };

  nameChangedHandler = (event, id) => {
    const personIndex = this.state.persons.findIndex(p => {
      return p.id === id;
    });

    const person = {
      ...this.state.persons[personIndex]
    }

    person.name = event.target.value;

    const persons = [...this.state.persons];
    persons[personIndex] = person;

    this.setState({ persons: persons });
  }

  personDeleteHandler = (index) => {
    const persons = [...this.state.persons];
    persons.splice(index, 1);
    this.setState({ persons: persons });
  }

  togglePersonsHandler = () => {
    const showStatus = this.state.showPersons;
    this.setState({ showPersons: !showStatus })
  }

  render() {
    let persons = null;

    if (this.state.showPersons) {
      persons = <Persons
        persons={this.state.persons}
        clicked={this.personDeleteHandler}
        changed={this.nameChangedHandler} />
    }

    return (
      <div className={styles.App} >
        <Cockpit
          persons={this.state.persons}
          showPersons={this.state.showPersons}
          clicked={this.togglePersonsHandler} />
        {persons}
      </div >
    );
  }
}

export default App;
