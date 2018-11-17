package domain;

//存放属性值
public class Product {

	private int id; // 编号
	private String productname; // 产品名称
	private String address; // 地址
	private int price; // 价钱

	public int getId() {
		return id;
	}

	public void setId(int id2) {
		this.id = id2;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {

		return "id:" + id + "\tproductname:" + productname + "\taddress:" + address + "\tprice:" + price;
	}

}
