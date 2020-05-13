import React, {useContext, useEffect, useState} from "react";
import {ChampionContext} from "../context/ChampionContext";

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
                {items.map((data)=>

                    <div>
                        <img src={`${data.icon_name}.webp`} onMouseEnter={()=>setOnMouse(true)} onMouseLeave={()=>setOnMouse(false)}/>
                        {onMouse && <div>{data.name}</div>}
                    </div>
                )}
            </div>
        </div>
    )
}