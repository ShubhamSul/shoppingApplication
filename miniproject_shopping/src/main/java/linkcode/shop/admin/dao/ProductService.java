package linkcode.shop.admin.dao;

import java.util.List;

import linkcode.shop.admin.model.Product;


public interface ProductService {
	String createProduct(List <Product> lst);
	List<Product> retriveProduct(int ProdId);
	boolean deleteProduct(int prodId);
	List <Product> getAllProduct();
}