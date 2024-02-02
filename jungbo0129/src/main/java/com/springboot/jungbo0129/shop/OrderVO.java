package com.springboot.jungbo0129.shop;

import lombok.Data;

@Data
public class OrderVO {
  private int order_idx;
  private int cart_idx;
  private int product_idx;
  private String product_name;
  private int product_amount;
  private int total_price;
  private int order_price;
  private String order_today;
}