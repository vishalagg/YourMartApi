package com.nagarro.yourmartapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nagarro.yourmartapi.entity.Category;
import com.nagarro.yourmartapi.entity.Seller;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponse {
	private int id;
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
	private Category category;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

}
