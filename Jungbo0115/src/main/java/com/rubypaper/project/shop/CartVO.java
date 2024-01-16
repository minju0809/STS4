package com.rubypaper.project.shop;

import lombok.Data;

@Data
public class CartVO {	
	private int cart_id;
	private int product_id;
	private String product_name;
	private int product_amount;
	private int product_price;
}
