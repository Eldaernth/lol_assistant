import React from "react";
import "../css/Homepage.css"
import {Link} from "react-router-dom";

export default function Homepage() {
    return (
        <div>
            <h1>Champions</h1>
            <div className="champions_wrapper">
                <div className="img_wrapper">
                    <Link to="/Wukong">
                        <img src="/wukong_face.jpeg" className="icon"/>
                    </Link>
                </div>
                <div className="img_wrapper">
                    <Link to="/champion/Ahri">
                        <img src="/ahri_face.jpeg" className="icon"/>
                    </Link>
                </div>
            </div>
            <div>

            </div>
        </div>)
}