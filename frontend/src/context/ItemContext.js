import React, {createContext, useState} from "react";
import Axios from "axios";

export const ItemContext = createContext();

export function ItemProvider(props) {
    const [items,setItems] = useState([]);
    const [isItemAdded,setIsItemAdded] = useState(false);
    const itemsMethods = {
        getItems: () => {
            Axios.get(`http://localhost:8080/items`)
                .then((res) => {
                    setItems(res.data);
                });
        },
        addItemBuild: (name, pickedItems, champ) => {
            Axios.post(`http://localhost:8080/${champ}/item_builds`, {
                name: name,
                items: pickedItems,
                champions: champ
            }, {
                headers: {
                    "Content-type": "application/json",
                    "Access-Control-Allow-Origin": "http://localhost:3000",
                    'Accept': 'application/json'
                }
            }).then(res => {
                isItemAdded ? setIsItemAdded(false) : setIsItemAdded(true);
            })
        },
        deleteItemBuild:(name) =>{
            Axios.delete(`http://localhost:8080/item_builds/delete/${name}`)
                .then(res=>{
                    console.log(res.data);
                })
        }
    };

    return(
        <ItemContext.Provider value={{items,setItems,itemsMethods,isItemAdded}}>
            {props.children}
        </ItemContext.Provider>
    )
}