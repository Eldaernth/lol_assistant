import React, {useContext, useEffect} from "react";
import {ChampionContext} from "../context/ChampionContext";
import "../css/Skills.css"

export default function Skills({name}) {
    const {championMethods, skills} = useContext(ChampionContext);

    useEffect(() => {
        championMethods.getChampionSkills(name)
    }, []);
    return (
        <div id="skills" className="champ_details">
            <h1>Skills</h1>
            <div className="skill_wrapper">
                {skills.map((row) =>
                    <div className="skill_details">
                        <div className="skill_icon">
                        <img src={`/${row.icon_name}.webp`}/>
                        </div>
                        <div className="skill_description">
                        <h2>{row.name}</h2>
                        <p>{row.description}</p>
                        </div>
                    </div>
                )}
            </div>
        </div>
    )
}