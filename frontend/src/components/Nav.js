import React from "react";
import "../css/Nav.css"

export default function NavBar() {
    return (
        <div className="navbar">
            <div className="logo_wrapper">
                <a href="/">
                <span className="app_name">Lol Assistant</span>
                </a>
            </div>
            <div className="sign_buttons">
                <ul>
                    <li className="sign_in">Sign in</li>
                    <li className="sign_up">Sign up</li>
                </ul>
            </div>
        </div>
    )
}