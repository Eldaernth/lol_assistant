import React, {useContext, useEffect, useState} from "react";
import {ChampionContext} from "../context/ChampionContext";
import "../css/Skills.css"

export default function Skills({name}) {
    const {championMethods, skills} = useContext(ChampionContext);
    const [isDisplayed,setIsDisplayed] = useState(false);

    useEffect(() => {
        championMethods.getChampionSkills(name)
    }, []);
    return (
        <div id="skills"  className="tab">
            <h1 onClick={()=>setIsDisplayed(!isDisplayed)}>Skills</h1>
            {isDisplayed && <div className="skill_wrapper">
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
            </div>}
        </div>
    )
}