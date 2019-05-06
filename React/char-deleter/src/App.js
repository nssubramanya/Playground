import React, { Component } from 'react';
import './App.css';
import Validator from "./Validator/Validator";
import CharComponent from "./CharComponent/CharComponent";

class App extends Component {

  state = {
    inputText: []
  };

  inputChangeHandler = (event) => {
    this.setState({
      inputText: event.target.value.split('')
    })
  }

  deleteCharComponent = (index) => {
    let text = [...this.state.inputText];
    console.log(index + " " + text)
    text.splice(index, 1);
    console.log(text);
    this.setState({
      inputText: text
    });
  }

  render() {
    let charComponents = "";

    if (this.state.inputText.length > 0) {
      charComponents = (
        <div>
          {
            this.state.inputText.map((ch, index) => {
              return <CharComponent
                character={ch}
                click={() => this.deleteCharComponent(index)}
                key={index}
              />
            })
          }
        </div>
      )
    }

    return (
      <div>
        <h3>Text Validator, Selector and Deleter</h3>
        <input
          className="App-input"
          type="text"
          onChange={(event) => this.inputChangeHandler(event)}
          value={this.state.inputText.join('')}
          placeholder="Random Text" />

        <p>Text Length: {this.state.inputText.length}</p>
        <Validator textLength={this.state.inputText.length} />
        {charComponents}
      </div>
    )
  }
}

export default App;
