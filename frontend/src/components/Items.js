import React, {useContext, useEffect, useState} from "react";
import {ChampionContext} from "../context/ChampionContext";
import "../css/Items.css";

export default function Items({name}) {
    const {championMethods,items} = useContext(ChampionContext);
    const [onMouse,setOnMouse] = useState(false);

    useEffect(()=>{
        championMethods.getChampionItems(name);
    },[])
    console.log(items);

    return (
        <div>
            <h1>Builds</h1>
            <div>
            <h2>Popular items</h2>
                <div className="skill_wrapper">
                    {items.map((row) =>
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
        </div>
    )
}