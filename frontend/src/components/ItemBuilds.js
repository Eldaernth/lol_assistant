import React, {useContext, useEffect, useState} from "react";
import {ItemContext} from "../context/ItemContext";
import "../css/Items.css"
import update from 'react-addons-update';

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
                        }
                        else if (row.picked !== false){
                            items[row.id - 1].picked = false;
                            setPickedItems(pickedItems.filter(e=> e !== row))
                        }
                    }}>
                        <img src={`${row.icon_name}.webp`}/>
                        <h4>{row.name}</h4>
                    </div>
                )}
            </div>
            <button className="detail_wrapper add_button">Add new build</button>
        </div>
    )
}