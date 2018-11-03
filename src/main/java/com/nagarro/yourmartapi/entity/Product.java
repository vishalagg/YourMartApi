package com.nagarro.yourmartapi.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private Seller seller;
	
	public void setId(int id) {
		this.id = id;
	}

	private String name;
	private String code;

	private int status;
	private int mrp;
	private int ssp;
	private int ymp;
	private String shortDescription;
	private String longDescription;
	private String instruction;
	private String dimensions;
	private String comment;
	private String attributes;
	
	
	@ManyToOne
	private Category category;

	@CreationTimestamp
	private Date createdAt;
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@UpdateTimestamp
	private Date updatedAt;
	
	public int getId() {
		return id;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getMrp() {
		return mrp;
	}
	
	public void setMrp(int mrp) {
		this.mrp = mrp;
	}
	
	public int getSsp() {
		return ssp;
	}
	
	public void setSsp(int ssp) {
		this.ssp = ssp;
	}
	
	public int getYmp() {
		return ymp;
	}
	
	public void setYmp(int ymp) {
		this.ymp = ymp;
	}
	
	public String getShortDescription() {
		return shortDescription;
	}
	
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	
	public String getLongDescription() {
		return longDescription;
	}
	
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	
	public String getInstruction() {
		return instruction;
	}
	
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	
	public String getDimensions() {
		return dimensions;
	}
	
	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getAttributes() {
		return attributes;
	}
	
	public void setAttributes(String attribues) {
		this.attributes = attribues;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
}
