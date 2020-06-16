import React, {createContext, useState} from "react";
import Axios from "axios";

export const ChampionContext = createContext();

export function ChampionProvider(props) {
    const [champion, setChampion] = useState({});
    const [skills, setSkills] = useState([]);
    const [items ,setItems] = useState([]);
    const [names,setNames] = useState([]);
    const [buildId,setBuildId] = useState([]);

    const championMethods =
        {
            getChampionDetails: (name) => {
                Axios.get(`http://localhost:8080/${name}`)
                    .then((res) => {
                        setChampion(res.data);
                    });
            },
            getChampionSkills:(name)=>{
                Axios.get(`http://localhost:8080/${name}/skills`)
                    .then((res) => {
                        setSkills(res.data);
                    });
            },
            getChampionItems:(name)=>{
                Axios.get(`http://localhost:8080/${name}/item_builds`)
                    .then((res) => {
                       console.log(res.data);
                    });
            }
            };
    return (
        <ChampionContext.Provider value={{champion, skills, championMethods,items,names,buildId}}>
            {props.children}
        </ChampionContext.Provider>
    )
}