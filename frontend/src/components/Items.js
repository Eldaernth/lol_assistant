import React, {useContext, useEffect, useState} from "react";
import {ChampionContext} from "../context/ChampionContext";
import {ItemContext} from "../context/ItemContext";
import "../css/Items.css";
import { faTimes } from '@fortawesome/free-solid-svg-icons'
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";

export default function Items({name}) {
    const {championMethods,items,names} = useContext(ChampionContext);
    const {isItemAdded,itemsMethods,isItemDeleted} = useContext(ItemContext);
    const [isDisplayed,setIsDisplayed] = useState(false);
    let index = 0;
    useEffect(()=>{
        championMethods.getChampionItems(name);
    },[isItemAdded]);
    return (
        <div className="tab">
            <h1 id="builds" onClick={()=>setIsDisplayed(!isDisplayed)}>Builds</h1>
            {isDisplayed && <div>
                <div className="skill_wrapper">
                    {names.map((name)=>
                        <div className="item_build_wrapper">
                            <h2>{name}</h2>
                            <button className="delete_button" onClick={()=> itemsMethods.deleteItemBuild(name)}><FontAwesomeIcon icon={faTimes} color="white" /></button>
                            {items[index].map((item)=>
                                <img src={`${item.icon_name}.webp`}/>
                            )}
                            <div className="index">{index++}</div>
                        </div>
                    )}
                </div>
            </div>}
        </div>
    )
}