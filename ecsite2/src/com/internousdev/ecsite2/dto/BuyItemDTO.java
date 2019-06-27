package com.internousdev.ecsite2.dto;

public class BuyItemDTO {
	public int id;

	public String itemName;

	public String itemPrice;

	public int itemStock;


	public String getItemName(){
		return itemName;
	}

	public void setItemName(String itemName){
		this.itemName=itemName;
	}

	public String getItemPrice(){
		return itemPrice;
	}

	public void setItemPrice(String itemPrice){
		this.itemPrice=itemPrice;
	}

	public int getItemStock() {
		return itemStock;
	}

	public void setItemStock(int itemStock) {
		this.itemStock=itemStock;
	}

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}


}
