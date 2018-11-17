package handles;
//结果集接口 如果有多张表需要进行查询操作 可调用出接口查询结果

import java.sql.ResultSet;
//一种位置的类型
public interface IResultSethandles<T> {

	T handles(ResultSet rs) throws Exception;   //重构的查询模板的接口 用来查询多张表时 提供一个统一的接口结果集处理
}
