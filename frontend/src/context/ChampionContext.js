import React, {createContext, useState} from "react";
import Axios from "axios";

export const ChampionContext = createContext();

export function ChampionProvider(props) {
    const [champion, setChampion] = useState({});
    const [skills, setSkills] = useState([]);

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
            }
            };
    return (
        <ChampionContext.Provider value={{champion, skills, championMethods}}>
            {props.children}
        </ChampionContext.Provider>
    )
}