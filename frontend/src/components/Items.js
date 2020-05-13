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
                <div className="item_img_wrapper">
                {items.map((data)=>

                    <div>
                        <div className="item_img">
                        <img src={`${data.icon_name}.webp`} onMouseEnter={()=>setOnMouse(true)} onMouseLeave={()=>setOnMouse(false)}/>
                        <div className={onMouse || `item_popup`}>{data.name}</div>
                        </div>
                    </div>
                )}
            </div>
            </div>
        </div>
    )
}