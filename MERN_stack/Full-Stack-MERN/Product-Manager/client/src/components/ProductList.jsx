import React from 'react'
import axios from 'axios';
import { Link } from '@reach/router';

const ProductList = (props) => {
    const { removeFromDom } = props;

    const deleteProduct = (productId) => {
        axios.delete('http://localhost:8000/api/products/' + productId)
            .then(res => {
                removeFromDom(productId)
            })
            .catch(err => console.error(err));
    }
    return (
        <div>
            {props.product.map((product, i) =>

                <div key={i}>
                    <Link to={`/` + product._id} key={i}>{product.title}</Link >

                        <button onClick={(e) => { deleteProduct(product._id) }}>
                            Delete
                        </button>
                        </div>
            )}
        </div>
    )
}

export default ProductList;