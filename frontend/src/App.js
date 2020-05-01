import React from 'react';
import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router,Switch,Route} from 'react-router-dom';
import Homepage from "./Homepage";
import NavBar from "./Nav";

function App() {
  return (
    <div className="App">
        <NavBar/>
      <Router>
        <Switch>
          <Route path="/homepage" component={Homepage}/>
        </Switch>
      </Router>
    </div>
  );
}

export default App;