package com.kevin.mp2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;
	

	@Column(nullable=false,length=100,name = "sellerId")
	private Long sellerId;
	
	
	@Column(nullable=true,length=100,name = "buyerId")	
	private Long buyerId;
	
	@Column(nullable=true,length=100, name="descr")
	private String descr;
	
	//@Column(nullable=true)
	//private String item_image; // img path
	
	@Column(nullable=false,length=100)
	private String item_name;
	
	@Column(nullable=false,length=100, name="starting_price")
	private double starting_price;
	
	@Column(nullable=true,length=100, name="most_recent_bid")
	private double most_recent_bid;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public double getStarting_price() {
		return starting_price;
	}

	public void setStarting_price(double starting_price) {
		this.starting_price = starting_price;
	}

	public double getMost_recent_bid() {
		return most_recent_bid;
	}

	public void setMost_recent_bid(double most_recent_bid) {
		this.most_recent_bid = most_recent_bid;
	}
}