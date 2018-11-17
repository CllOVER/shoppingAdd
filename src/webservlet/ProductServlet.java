package webservlet;

//servlet传输类
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ProductDao;
import dao.impl.Productimpl;
import domain.Product;


@WebServlet("/product")
public class ProductServlet extends HttpServlet {

	// 一般情况下，建议序列化的class都给一个序列化的ID，这样可以保证序列化的成功，版本的兼容性。
	private static final long serialVersionUID = 1L;
	
	
	private ProductDao dao;

	@Override
	public void init() throws ServletException { // 初始化
		dao = new Productimpl(); // 导入丛数据库中获取结果
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 请求操作 -->调用各个方法
		req.setCharacterEncoding("UTF-8"); // 设置编码格式
		String cmd = req.getParameter("cmd"); // cmd 表示命令
		// 判断命令是否属于其中之一
		if ("edit".equals(cmd)) { // edit编辑
			this.edit(req, resp);
		} else if ("dalete".equals(cmd)) {
			this.dalete(req, resp);
		} else if ("save".equals(cmd)) {
			this.update(req, resp);
		} else {
			this.list(req, resp); // 没有相关操作进行查询操作
		}
	}

	// 查询操作
	protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接受（请求参数，封装对象）--> 处理（调用业务处理请求）-->（jsp） 跳转
		List<Product> list = dao.list(); // 调用属性 存储在集合中
		req.setAttribute("products", list); // 设置属性 用来获取list的值
		req.getRequestDispatcher("/product/ProductQuery.jsp").forward(req, resp); // 转发重定向

	}

	// 编辑操作
	protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 请求参数，封装对象 //处理业务请求 //控制界面跳转
		String id = req.getParameter("id");
		if (req.getParameter("id") != null) {
			Integer idInteger = new Integer(req.getParameter("id"));
			Product product = dao.get(idInteger);
			req.setAttribute("product", product);
		}
		
		
		req.getRequestDispatcher("/product/ProductSave.jsp").forward(req, resp); // 转发重定向

	}

	// 删除操作
	protected void dalete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("id") != null) {
			Integer id = new Integer(req.getParameter("id"));
			dao.dalete(id);
		}
		resp.sendRedirect("/shopping/product"); // 删除成功后先定向到逻辑
	}

	// 更新操作
	protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 请求参数，封装对象
		Product p = new Product(); // 封装成一条对象
		// 丛客户端中获取属性 设置新的属性 调用保存
		int idInteger = new Integer(req.getParameter("id")); // 强制转换类型
		String productname = req.getParameter("productname");
		String address = req.getParameter("address");
		int priceInteger = new Integer(req.getParameter("price")); // 强制转换类型
		p.setId(idInteger);
		p.setProductname(productname);
		p.setAddress(address);
		p.setPrice(priceInteger);
		// 处理业务请求
		dao.save(p);
		// 控制界面跳转
	
		resp.sendRedirect("/shopping/product");
	}

}
