package linkcode.shop.admin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import linkcode.shop.admin.dao.ProductService;
import linkcode.shop.admin.daoimpl.ProductServiceImpl;
import linkcode.shop.admin.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ProductController
 */
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int prodId=Integer.parseInt(request.getParameter("prodId"));
		String prodName=request.getParameter("prodName");
		double prodPrice=Double.parseDouble(request.getParameter("prodPrice"));
		int prodQty=Integer.parseInt(request.getParameter("prodQty"));
		
		Product prodobj=new Product(prodId, prodName, prodPrice, prodQty);
		//Product  prodobj=new Product(prodId, prodName, prodPrice, prodQty);
		List<Product> lstproduct=new ArrayList<Product>();
		lstproduct.add(prodobj);
		
		ProductService proddao=new ProductServiceImpl();
		String str=proddao.createProduct(lstproduct);
		System.out.println("In controller str is "+str);
		HttpSession session=request.getSession();
		if(str.equals("valid")) {
			str="Product Added to db";
			
		}
		session.setAttribute("msg",str);
		response.sendRedirect("Product.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}