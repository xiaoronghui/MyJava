package Java进阶.内省的简单应用;

import java.util.Date;

public class OrderGoods {
	private  int orderGoodsId;
	private double claimValue;
	private String goodsMemo;
	private String goodsName;
	private String goodsType;
	private Date inputDate;
	private String inputMan;
	private int num;
	private double volume;
	private double weight;
	
	public int getOrderGoodsId() {
		return orderGoodsId;
	}
	public void setOrderGoodsId(int orderGoodsId) {
		this.orderGoodsId = orderGoodsId;
	}
	public double getClaimValue() {
		return claimValue;
	}
	public void setClaimValue(double claimValue) {
		this.claimValue = claimValue;
	}
	public String getGoodsMemo() {
		return goodsMemo;
	}
	public void setGoodsMemo(String goodsMemo) {
		this.goodsMemo = goodsMemo;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public Date getInputDate() {
		return inputDate;
	}
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	public String getInputMan() {
		return inputMan;
	}
	public void setInputMan(String inputMan) {
		this.inputMan = inputMan;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	 
	 
}
