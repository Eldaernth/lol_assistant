import React, {useContext, useEffect, useState} from "react";
import {useParams} from "react-router-dom"
import {ChampionContext} from "../context/ChampionContext"
import "../css/ChampionsPage.css"
import Skills from "./Skills";
import Items from "./Items";
import ItemBuilds from "./ItemBuilds";


export default function ChampionPage() {
    let {name} = useParams();
    const {champion,championMethods} = useContext(ChampionContext);

    useEffect(() => {
        championMethods.getChampionDetails(name);
    }, [])

    return (
        <div className="champions_page">
            <div className="champ_img_wrapper">
                <img src="ahri.jpg" className="champ_img"/>
            </div>
            <div className="navigator">
                <ul>
                    <li><a href="#details"><h2>Details</h2></a></li>
                    <li><a href="#skills"><h2>Skills</h2></a></li>
                    <li><a href="#skills"><h2>Builds</h2></a></li>
                    <li><a href="#skills"><h2>Counters</h2></a></li>
                </ul>
            </div>
            <div className="champ_details" id="details">
                <h1>{champion.name}</h1>
                <h2>{champion.title}</h2>
                <div className="champ_header">
                    <a href="https://universe.leagueoflegends.com/en_US/race/vastaya/" className="link">
                        <div className="detail_wrapper race">
                            <h2>Class</h2>
                            <p>{champion.className}</p></div>
                    </a>
                    <a href="https://universe.leagueoflegends.com/en_US/race/vastaya/" className="link">
                        <div className="detail_wrapper race">
                            <h2>Race</h2>
                            <p>{champion.race}</p>
                        </div>
                    </a>
                </div>
                <div className="champ_middle">
                    <div className="detail_wrapper">
                        <p>{champion.lore}</p>
                        <a href="https://universe.leagueoflegends.com/en_US/story/champion/ahri/" className="more_lore">More lore</a>
                    </div>
                </div>
                <div className="champ_bottom">
                    <a href="https://universe.leagueoflegends.com/en_US/region/ionia/" className="link">
                        <div className="detail_wrapper race">
                            <h2>Region</h2>
                            <p>{champion.location}</p>
                        </div>
                    </a>
                    <a href="https://universe.leagueoflegends.com/en_US/race/vastaya/" className="link">
                        <div className="detail_wrapper race">
                            <h2>Difficulty</h2>
                            <p>{champion.difficulty}</p>
                        </div>
                    </a>
                </div>
            </div>
            <Skills name={name}/>
            <Items name={name}/>
            <ItemBuilds name={name}/>
        </div>
    )
}