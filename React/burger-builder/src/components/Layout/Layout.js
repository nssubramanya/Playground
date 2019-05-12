import React from 'react';
import Aux from '../../hoc/Aux';
import classes from "./Layout.module.css";

const layout = (props) => (
  <React.Fragment>
    {/*<Aux>*/}
    <div>Toolbar, Side Drawer, Backdrop</div>
    <main className={classes.Content}>
      {props.children}
    </main>
    {/*</Aux>*/}
  </React.Fragment>
);

export default layout;