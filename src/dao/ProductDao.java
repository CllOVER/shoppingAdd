package dao;

import java.util.List;

import domain.Product;

//接口类 存放调用方法
//非public修饰符无法导进实现类中
public interface ProductDao {

	void save(Product obj); // 增加保存

	void update(Product obj); // 修改

	void dalete(int id); // 删除

	Product get(int id); // 通过id查询

	List<Product> list() ; // 用list进行多条查询

	

}
