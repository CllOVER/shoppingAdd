package test;

import java.util.List;

import org.junit.jupiter.api.Test;

import dao.ProductDao;
import dao.impl.Productimpl;
import domain.Product;
//测试类
public class ProductimplTest {

	ProductDao dao = new Productimpl();

	@Test
	void testSave() {
		Product p = new Product();
		p.setId(17);
		p.setProductname("宝马");
		p.setAddress("Germany");
		p.setPrice(2000000);
		dao.save(p);
	}

	@Test
	void testUpdate() {
		Product p = new Product();
		p.setProductname("shoes");
		p.setAddress("天津");
		p.setPrice(121);
		p.setId(13);
		dao.update(p);

	}

	@Test
	void testDalete() {
		dao.dalete(17);
		System.out.println("删除成功");
	}

	@Test
	void testGet() {
		Product p = dao.get(1);
		System.out.println(p);
	}

	@Test
	void testList() {
		List<Product> list = dao.list(); // 丛实现类中调出list
		for (Product p : list) {
			System.out.println(p);
		}

	}

}
