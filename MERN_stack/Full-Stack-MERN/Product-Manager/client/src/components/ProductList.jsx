import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { Link } from '@reach/router';
import DeleteButton from './DeleteButton';

const ProductList = (props) => {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8000/api/products')
        .then(res => setProducts(res.data));
    }, [products])
    
    const removeFromDom = productId => {
        axios.get('http://localhost:8000/api/products')
        setProducts(products.filter(product => product._id != productId))
    }
    return (
        <div>
            {products.map((product, i) =>
                <div key={i}>
                    <Link to={`/` + product._id}>{product.title}</Link >
                    |
                    <Link to={`/` + product._id + `/edit`} >Edit</Link >
                    |
                    <DeleteButton productId={product._id} successCallback={() => removeFromDom(product._id)} />
                </div>
            )}
        </div>
    )
}

export default ProductList;