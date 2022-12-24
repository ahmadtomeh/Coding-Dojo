import React, { useEffect, useState } from 'react'
import axios from 'axios';
import ProductForm from '../components/ProductForm';
import ProductList from '../components/ProductList';

export default () => {
    const [ message, setMessage ] = useState("Loading...")
    const [product, setProduct] = useState([]);
    const [loaded, setLoaded] = useState(false);
    useEffect(()=>{
        axios.get("http://localhost:8000/api/products")
            .then(res=> {
                setProduct(res.data);
                setLoaded(true);
                setMessage(res.data.message)
                console.log("aaa")
            })
            .catch(err => console.error(err));
    }, []);
    return (
        <div>
            <h2>Message from the backend: {message}</h2>
            <ProductForm/>
            <hr/>
            {loaded && <ProductList product={product}/>}

        </div>
    )
}