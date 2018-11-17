package Template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Utils.JdbcUtils;
import handles.IResultSethandles;

//重构后  存放jdbc连接的几个选项的模板   
public class jdbcTemplate {
//参数为为移植到此的参数  sql语句  和定义个数组接收属性
	public static void update(String sql, Object...params) {    //使用…将参数声明成可变长参数。
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtils.getconn(); // 调用Utils方法
			ps = conn.prepareStatement(sql);
			// 设置占位符参数
			for (int index = 0; index < params.length; index++) {
				ps.setObject(index + 1, params[index]);
			}
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, null);
		}
	}
	
	//query的类型  由参数决定
	public static <T>T query(String sql,IResultSethandles<T> rsh, Object...params) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getconn();
		    ps = conn.prepareStatement(sql);
			
			//设置占位符
			for(int index = 0;index <params.length; index++) {
				ps.setObject(index + 1, params[index]);
			}
			rs = ps.executeQuery();   //处理结果集
			
			return rsh.handles(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			JdbcUtils.close(conn, null, null);
		}
		throw new RuntimeException("查询错误");
	}
	
}
