import React, {createContext, useState} from "react";
import Axios from "axios";

export const ItemContext = createContext();

export function ItemProvider(props) {
    const [items,setItems] = useState([]);

    const itemsMethods = {
        getItems:()=>{
            Axios.get(`http://localhost:8080/items`)
                .then((res) => {
                    setItems(res.data);
                });
        }
    }

    return(
        <ItemContext.Provider value={{items,setItems,itemsMethods}}>
            {props.children}
        </ItemContext.Provider>
    )
}