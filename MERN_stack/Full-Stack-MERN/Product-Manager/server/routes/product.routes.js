const ProductController = require('../controllers/product.controller');
module.exports = function(app){
    app.get('/api', ProductController.index);
    app.put('/api/products/:id', ProductController.updateProduct);
    app.get('/api/products', ProductController.getAllProducts);
    app.get('/api/products/:id', ProductController.getProduct);
    app.post('/api/products/new', ProductController.createProduct);
    app.delete('/api/products/:id', ProductController.deleteProduct);

}