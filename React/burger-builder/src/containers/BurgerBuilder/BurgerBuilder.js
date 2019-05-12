import React, { Component } from 'react';
import Burger from '../../components/Burger/Burger';
import BuildControls from '../../components/Burger/BuildControls/BuildControls';
import Modal from "../../components/UI/Modal/Modal";
import OrderSummary from "../../components/Burger/OrderSummary/OrderSummary";
import Aux from "../../hoc/Aux";

const INGREDIENT_PRICES = {
  salad: 0.5,
  cheese: 0.4,
  meat: 1.3,
  bacon: 0.7
}

export const BURGER_BASIC_PRICE = 4;

class BurgerBuilder extends Component {
  // This is also another way of state initialization
  // constructor(props) {
  //   super(props);
  //   this.state = {}
  // }

  state = {
    ingredients: {
      salad: 0,
      bacon: 0,
      cheese: 0,
      meat: 0
    },
    totalPrice: BURGER_BASIC_PRICE,
    purchaseable: false,
    purchasing: false
  };

  updatePurchaseState(newPrice) {
    let burgerPurchaseable: boolean = false;
    if (newPrice !== BURGER_BASIC_PRICE) {
      burgerPurchaseable = true;
      this.setState({ purchaseable: burgerPurchaseable });
    }
  }

  purchaseHandler = () => {
    this.setState({ purchasing: true });
  }

  purchaseCancelHandler = () => {
    this.setState({ purchasing: false });
  }

  addIngredientHandler = (type) => {
    const oldCount = this.state.ingredients[type];

    const updatedIngredients = {
      ...this.state.ingredients
    };
    updatedIngredients[type] = oldCount + 1;
    const priceAddition = INGREDIENT_PRICES[type];
    const newPrice = this.state.totalPrice + priceAddition;

    this.setState({
      ingredients: updatedIngredients,
      totalPrice: newPrice
    })

    this.updatePurchaseState(newPrice);

    console.log(this.state.ingredients, this.state.totalPrice);
  }

  removeIngredientHandler = (type) => {
    const oldCount = this.state.ingredients[type];

    const updatedIngredients = {
      ...this.state.ingredients
    };

    if (oldCount >= 1)
      updatedIngredients[type] = oldCount - 1;

    const priceReduction = INGREDIENT_PRICES[type];
    const newPrice = this.state.totalPrice - priceReduction;

    this.setState({
      ingredients: updatedIngredients,
      totalPrice: newPrice
    })

    this.updatePurchaseState(newPrice);

    console.log(this.state.ingredients, this.state.totalPrice);
  }



  render() {
    const disabledInfo = {
      ...this.state.ingredients
    };
    for (let key in disabledInfo) {
      disabledInfo[key] = disabledInfo[key] <= 0;
    }
    return (
      <Aux>
        {}
        <Modal show={this.state.purchasing} modalClosed={this.purchaseCancelHandler}>
          <OrderSummary ingredients={this.state.ingredients} />
        </Modal>
        <Burger ingredients={this.state.ingredients} />

        <BuildControls
          ingredientAdded={this.addIngredientHandler}
          ingredientRemoved={this.removeIngredientHandler}
          disabled={disabledInfo}
          price={this.state.totalPrice}
          purchaseable={this.state.purchaseable}
          purchasing={this.purchaseHandler} />
      </Aux>
    )
  }
}

export default BurgerBuilder;
