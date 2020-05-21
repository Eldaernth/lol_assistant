import React, {createContext, useState} from "react";
import Axios from "axios";

export const ItemContext = createContext();

export function ItemProvider(props) {
    const [items,setItems] = useState([]);

    const itemsMethods = {
        getItems: () => {
            Axios.get(`http://localhost:8080/items`)
                .then((res) => {
                    setItems(res.data);
                });
        },
        addItemBuild: (name, pickedItems, champ) => {
            Axios.post(`http://localhost:8080/items`, {
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
                console.log(res);
            })
        },
    };

    return(
        <ItemContext.Provider value={{items,setItems,itemsMethods}}>
            {props.children}
        </ItemContext.Provider>
    )
}