import React, {useEffect, useState} from "react";
import {useParams} from "react-router-dom"
import Axios from "axios";
import "./ChampionsPage.css"

export default function ChampionPage() {
    let {name} = useParams();
    const [champion, setChampion] = useState({});
    const [skills, setSkills] = useState({});
    useEffect(() => {
        Axios.get(`http://localhost:8080/${name}`)
            .then((res) => {
                setChampion(res.data);
            });
    }, [])
    console.log(champion);
    return (
        <div className="champions_page">
            <div className="champ_img_wrapper">
                <img src="ahri.jpg" className="champ_img"/>
            </div>
            <div>
                <ul>
                    <li><a href="#details"><h2>Details</h2></a></li>
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

        </div>
    )
}