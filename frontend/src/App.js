import React from 'react';
import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router,Switch,Route} from 'react-router-dom';
import Homepage from "./Homepage";
import NavBar from "./Nav";
import ChampionPage from "./ChampionPage";

function App() {
  return (
    <div className="App">
        <NavBar/>
      <Router>
        <Switch>
          <Route path="/"  exact component={Homepage}/>
          <Route path="/:name" component={ChampionPage}/>
        </Switch>
      </Router>
    </div>
  );
}

export default App;
