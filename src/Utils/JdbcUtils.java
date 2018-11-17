package Utils;
//数据库存储包


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JdbcUtils {

	// 重构设计 静态常亮
	public static DataSource ds = null;
	// 静态代码块 ，随JVM加载
	static {
		try {
			Properties p = new Properties();   //创建配置对象
			p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("druid.properties"));
			ds = DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	// 获取Connection连接
	public static Connection getconn() {
		try {
			return ds.getConnection();        //获取连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 关闭资源
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
