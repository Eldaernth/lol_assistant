import React from 'react';
import logo from '../logo.svg';
import '../css/App.css';
import {BrowserRouter as Router,Switch,Route} from 'react-router-dom';
import Homepage from "./Homepage";
import NavBar from "./Nav";
import ChampionPage from "./ChampionPage";
import {ChampionProvider} from "../context/ChampionContext";

function App() {
  return (
    <div className="App">
        <NavBar/>
      <Router>
        <Switch>
            <ChampionProvider>
          <Route path="/"  exact component={Homepage}/>
          <Route path="/:name" component={ChampionPage}/>
            </ChampionProvider>
        </Switch>
      </Router>
    </div>
  );
}

export default App;
