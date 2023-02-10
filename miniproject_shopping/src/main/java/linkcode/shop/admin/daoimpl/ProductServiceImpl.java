package linkcode.shop.admin.daoimpl;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import linkcode.shop.admin.dao.ProductService;
import linkcode.shop.admin.model.Product;
import linkocde.shop.db.ShopDb;

public class ProductServiceImpl implements ProductService {

	@Override
	public String createProduct(List<Product> lst) {
		// TODO Auto-generated method stub
		String str=null;
		ShopDb shopobj=new ShopDb();
		Connection con=shopobj.getConnection();
		Product prod=lst.get(0);
		int i=0;
		try {
			PreparedStatement pstate=con.prepareStatement("insert into product values(?,?,?,?)");
			pstate.setInt(1,prod.getProdId());
			pstate.setString(2,prod.getProdName());
			pstate.setDouble(3,prod.getProdPrice());
			pstate.setInt(4,prod.getProdQty());
			i=pstate.executeUpdate();
			if(i>0) {
				str="valid";
			}
		} catch (SQLException e) {
			System.out.println("test1..");
			System.out.println(e.getMessage());
			str=e.getMessage();
			e.printStackTrace();


		}

		return str;
		
	}

	@Override
	public List<Product> retriveProduct(int ProdId) {
		List<Product> prodlst=null;
		ShopDb shopobj=new ShopDb();
		Connection con=shopobj.getConnection();
		
		try {
			PreparedStatement pstate=con.prepareStatement("select*from product where proId=?");
			pstate.setInt(1, ProdId);
			ResultSet rs=pstate.executeQuery();
			if(rs.next()) {
				prodlst=new ArrayList<Product>();
				Product prod=new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4));
				prodlst.add(prod);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		
		return prodlst;
	}

	@Override
	public boolean deleteProduct(int prodId) {
		// TODO Auto-generated method stub
		ShopDb shopobj=new ShopDb();
		Connection con=shopobj.getConnection();
		try {
			PreparedStatement pstate=con.prepareStatement("delete from product where proId=?");
			pstate.setInt(1, prodId);
			boolean rd=pstate.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return true;
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> prodlst=new LinkedList<Product>();
		ShopDb shopdao=new ShopDb();
		Connection con=shopdao.getConnection();
	
		try {
			PreparedStatement pstate=con.prepareStatement("select*from product");
			ResultSet rs=pstate.executeQuery();
			prodlst=new ArrayList<Product>();
			while(rs.next()) {
				Product prod=new Product(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getInt(4));
				prodlst.add(prod);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return prodlst;
	}
	}
