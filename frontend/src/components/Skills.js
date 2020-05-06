import React, {useContext} from "react";
import {ChampionContext} from "../context/ChampionContext";

export default function Skills() {
    const {skills} = useContext(ChampionContext)
    console.log(skills);
    return(
        <div>
            <ul>
                {skills.map((row)=>
                    <li>row.name</li>
                )}
            </ul>

        </div>
    )
}