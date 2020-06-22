import React from "react";
import {useParams} from "react-router-dom"
import "../css/ChampionsPage.css"
import Skills from "./Skills";
import Items from "./Items";
import ItemBuilds from "./ItemBuilds";
import ChampionDetails from "./ChampionDetails";
import InSiteNav from "./InSiteNav";


export default function ChampionPage() {
    let {name} = useParams();

    return (
        <div className="champions_page">
            <div className="champ_img_wrapper">
                <img src={`${name}.jpg`} className="champ_img"/>
            </div>
            <InSiteNav/>
            <ChampionDetails name={name}/>
            <Skills name={name}/>
            <Items name={name}/>
            <ItemBuilds name={name}/>
        </div>
    )
}