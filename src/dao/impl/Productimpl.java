package dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Template.jdbcTemplate;
import dao.ProductDao;
import domain.Product;
import handles.IResultSethandles;

public class Productimpl implements ProductDao { // ProductDao的实现类

	@Override
	public void save(Product obj) {
		String sql = "INSERT INTO product(id,productname,address,price) VALUES(?,?,?,?)";
		Object[] params = new Object[]{obj.getId(),obj.getProductname(),obj.getAddress(),obj.getPrice()};
		jdbcTemplate.update(sql,params);
		
	}

	@Override
	public void update(Product obj) {
		String sql = "UPDATE product SET productname=?,address=?,price=? WHERE id=?";
//		定义数组接收
		Object[] params = new Object[] {obj.getProductname(),obj.getAddress(),obj.getPrice(),obj.getId()};
		jdbcTemplate.update(sql,params);  //调用参数
	}

	@Override
	public void dalete(int id) {
		jdbcTemplate.update("DELETE FROM product WHERE id = ?", id);
	}

	@Override
	public Product get(int id){ 
			String sql = "SELECT * FROM product WHERE id = ? ";
			
			try {
				List<Product> list = jdbcTemplate.query(sql,new producthandles(),id);
				return  list.size() == 1?list.get(0):null; 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   //可以用集合查询索引中的一条信息
			return  null; 
	}

	@Override
	public List<Product> list(){
	
		try {
			return jdbcTemplate.query("SELECT * FROM product", new producthandles());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		}	
}

  class producthandles implements IResultSethandles<List<Product>>{

	public List<Product> handles(ResultSet rs) throws Exception{
		List<Product> list = new ArrayList<Product>();
	while (rs.next()) {
		Product p = new Product(); // 一天信息
		p.setId(rs.getInt("id")); // 设置显示id
		p.setProductname(rs.getString("productname")); // 设置显示名称
		p.setAddress(rs.getString("address")); // 设置显示地址
		p.setPrice(rs.getInt("price")); // 设置显示价格
		list.add(p);
	}
	return list;
	}
	
}
