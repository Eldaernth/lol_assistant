import React, {useContext, useEffect, useState} from "react";
import {ItemContext} from "../context/ItemContext";
import "../css/Items.css"
import Popup from "reactjs-popup";

export default function ItemBuilds({name}) {
    const {items,itemsMethods,isItemAdded} = useContext(ItemContext);
    const [pickedItems, setPickedItems] = useState([]);
    const [buildName,setBuildName] =useState("");
    const [isDisplayed,setIsDisplayed] = useState(false);

    useEffect(() => {
        itemsMethods.getItems();
    }, [isItemAdded]);
    return (
        <div className="tab">
            <h1 onClick={()=>setIsDisplayed(!isDisplayed)}>Items</h1>
            {isDisplayed && <div>
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
            </div>}
            <Popup contentStyle={{backgroundColor: "#1f1e1e", minHeight: "200px",display:"flex",flexDirection:"column",alignItems:"center"}} modal
                   trigger={<button className="detail_wrapper add_button">Add new build</button>}>
                { close =>(
                    <div className="form__group field">
                    <h2>Give name to the build</h2>
                    < div>
                    <input type="input" className="form__field" placeholder="Build name" name="name" id='name' required
                    value={buildName} onChange={(e)=>setBuildName(e.target.value)}/>
                    <label htmlFor="name" className="form__label"></label>
                    </div>
                    <button className="detail_wrapper add_button" onClick={() => {itemsMethods.addItemBuild(buildName, pickedItems, name);close()}}>Add</button>
                    </div>)
                }
            </Popup>
        </div>
    )
}