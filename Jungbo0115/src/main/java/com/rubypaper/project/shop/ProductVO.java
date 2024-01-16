package com.rubypaper.project.shop;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductVO {
	private int product_id;
	private String product_name;
	private int product_price;
	private String product_desc;
	private String product_imgStr;
	private MultipartFile product_img;
	private String product_date;
}
