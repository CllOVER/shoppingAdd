<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">

#body {background-color: #FFFFE0;}
#table {margin:150px auto;}
</style>

<meta charset="UTF-8">
<title>购物车</title>
</head>
<body id="body">
<div style="font-size: 20px; "><h1>购物车实例:</h1></div>
<a href="/shopping/product?cmd=edit">增加产品</a>
<table border="0.5" class="auto" id="table">
<tr>
<td width="100" align="center">产品图片信息</td>
<td width="100" align="center">产品编号</td>
<td width="150" align="center">产品名称</td>
<td width="100" align="center">产品产地</td>
<td width="100" align="center">产品价格</td>
<td width="120" align="center">操作功能</td>
</tr>
<c:forEach items="${products}" var="p">
<tr align="center"> 
<td  height="100" ><div style="height:70%; width: 70%;">
<a href="/shopping/product/ProductInformation.jsp?id=${p.id	}">
<img style="max-height: 100%"  src="/shopping/imgs/${p.id}.jpg" >
</a>
</div></td>
<td  height="100" >${p.id}</td>
<td  height="100" >${p.productname}</td>
<td  height="100" >${p.address }</td>
<td  height="100" >${p.price}</td>
<td><a href="/shopping/product?cmd=dalete&id=${p.id}">删除</a>&nbsp;&nbsp;<a href="/shopping/product?cmd=edit&id=${p.id}">修改</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>