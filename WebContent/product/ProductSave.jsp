<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#body{background-color: #FFFFE0;}
#table{margin: 150px auto;}
</style>
<meta charset="UTF-8">
<title>增加产品</title>
</head>
<body id="body">
<form action="/shopping/product?cmd=save" method="post">
<input type="hidden" value="${product.id}">
<table id="table">
<tr style="float: left;">
<td>产品图片</td>
<td  height="100" width="100" ><div style="height:70%; width: 70%;"><img style="max-height: 100%"  src="/shopping/imgs/${product.id}.jpg" ></div></td>
</tr>
<tr>      <!-- required 字段不能为空   disabled="true"   不可被修改   -->
<td>添加产品编号：<input type="number" placeholder="" name="id" value="${product.id }" required="required" min="0" ></td>
</tr>
<tr>
<td>添加产品名称：<input type="text" placeholder="" name="productname" value="${product.productname}" required="required"></td>
</tr>
<tr>
<td>添加产品产地：<input type="text" placeholder="" name="address" value="${product.address}" required="required"></td>
</tr>
<tr>
<td>添加产品价格：<input type="number" placeholder="" name="price" value="${product.price}" required="required" min="0"></td>
</tr>
<tr>
<td><input type="submit" name="" value="保存"></td>	
</tr>
</table>
</form>
</body>
</html>