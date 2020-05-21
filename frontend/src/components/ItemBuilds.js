import React, {useContext, useEffect, useState} from "react";
import {ItemContext} from "../context/ItemContext";
import "../css/Items.css"
import update from 'react-addons-update';
import Popup from "reactjs-popup";

export default function ItemBuilds() {
    const {items, setItems, itemsMethods} = useContext(ItemContext);
    const [pickedItems, setPickedItems] = useState([]);

    useEffect(() => {
        itemsMethods.getItems();
    }, []);
    console.log(pickedItems);
    return (
        <div>
            <h1>Items</h1>
            <h2>Select six item</h2>
            <div className="items">
                {items.map((row) =>
                    <div className={row.picked ? "item picked" : "item"} onClick={() => {
                        if (row.picked !== true && pickedItems.length < 6) {
                            items[row.id - 1].picked = true;
                            setPickedItems((prev => [...prev, row]))
                        } else if (row.picked !== false) {
                            items[row.id - 1].picked = false;
                            setPickedItems(pickedItems.filter(e => e !== row))
                        }
                    }}>
                        <img src={`${row.icon_name}.webp`}/>
                        <h4>{row.name}</h4>
                    </div>
                )}
            </div>
            <Popup contentStyle={{backgroundColor: "#1f1e1e", minHeight: "300px",display:"flex",flexDirection:"column",alignItems:"center"}} modal
                   trigger={<button className="detail_wrapper add_button">Add new build</button>}>
                    <h2>Give name to the build</h2>
                <div className="form__group field">
                    <input type="input" className="form__field" placeholder="Build name" name="name" id='name' required/>
                    <label htmlFor="name" className="form__label"></label>
                </div>
                <button className="detail_wrapper add_button">Add</button>
            </Popup>
        </div>
    )
}