import React, {useContext, useEffect, useState} from "react";
import {ChampionContext} from "../context/ChampionContext";
import {ItemContext} from "../context/ItemContext";
import "../css/Items.css";
import {Link} from "react-router-dom";

export default function Items({name}) {
    const {championMethods,items,names} = useContext(ChampionContext);
    const {isItemAdded} = useContext(ItemContext);
    const [onMouse,setOnMouse] = useState(false);
    let index = 0;
    useEffect(()=>{
        championMethods.getChampionItems(name);
    },[isItemAdded]);
    return (
        <div>
            <h1>Builds</h1>
            <div>
                <div className="skill_wrapper">
                    {names.map((name)=>
                        <div>
                            <h2>{name}</h2>
                            <button>Delete</button>
                            {items[index].map((item)=>
                                <img src={`${item.icon_name}.webp`}/>
                            )}
                            <div className="index">{index++}</div>
                        </div>
                    )}
                </div>
            </div>
        </div>
    )
}