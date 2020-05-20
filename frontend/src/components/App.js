import React from 'react';
import logo from '../logo.svg';
import '../css/App.css';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import Homepage from "./Homepage";
import NavBar from "./Nav";
import ChampionPage from "./ChampionPage";
import {ChampionProvider} from "../context/ChampionContext";
import ItemBuilds from "./ItemBuilds";
import {ItemProvider} from "../context/ItemContext";

function App() {
    return (
        <Router>

            <div className="App">
                <NavBar/>
                <Switch>
                    <ItemProvider>
                    <Route path="/item_builds" exact component={ItemBuilds}/>
                    </ItemProvider>
                    <ChampionProvider>
                        <Route path="/" exact component={Homepage}/>
                        <Route path="/:name" component={ChampionPage}/>
                    </ChampionProvider>

                </Switch>
            </div>
        </Router>
    );
}

export default App;
