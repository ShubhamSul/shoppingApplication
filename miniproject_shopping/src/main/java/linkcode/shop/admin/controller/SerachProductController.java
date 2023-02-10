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
import java.util.List;


public class SerachProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SerachProductController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String msg=null;
		int prodId=Integer.parseInt(request.getParameter("prodId"));
			ProductService proddao=new ProductServiceImpl();
			List<Product> lstprod=proddao.retriveProduct(prodId);
			HttpSession session=request.getSession();
			if(lstprod!=null)
			{
				session.setAttribute("prod",lstprod);
			}
			else
			{
				msg="Invalid Product Id";
				session.setAttribute("prod",msg);
			}
			response.sendRedirect("SearchProduct.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}