import React, {useContext, useEffect, useState} from "react";
import {ChampionContext} from "../context/ChampionContext";
import "../css/Items.css";

export default function Items({name}) {
    const {championMethods,items,names} = useContext(ChampionContext);
    const [onMouse,setOnMouse] = useState(false);
    let index = 0;

    useEffect(()=>{
        championMethods.getChampionItems(name);
    },[])
    console.log(names);
    return (
        <div>
            <h1>Builds</h1>
            <div>
                <div className="skill_wrapper">
                    {names.map((name)=>
                        <div>
                            <h2>{name}</h2>
                            {items[index].map((item)=>
                                <img src={`${item.icon_name}.webp`}/>
                            )}
                            <div className="index">{index++}</div>
                        </div>
                    )}
                </div>
                <button>Add new build</button>
            </div>
        </div>
    )
}