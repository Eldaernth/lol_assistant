import React from "react";
import "./Homepage.css"
import {Link} from "react-router-dom";

export default function Homepage() {
    return (
        <div>
            <h1>Champions</h1>
            <div className="champions_wrapper">
                <div className="img_wrapper">
                    <Link to="/wukong">
                    <img src="/wukong_face.jpeg"/>
                    </Link>
                </div>
                <div className="img_wrapper">
                    <Link to="/ahri">
                        <img src="/ahri_face.jpeg"/>
                    </Link>
                </div>
            </div>
            <div>

            </div>
        </div>)
}