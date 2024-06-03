package com.zettamine.spring.core.beans;


public class Car {
	private String modelName;
	private Float cost;
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public Float getCost() {
		return cost;
	}
	public void setCost(Float cost) {
		
		this.cost = cost;
	}
	public Car(String modelName, Float cost) {
		super();
		this.modelName = modelName;
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Car [modelName=" + modelName + ", cost=" + cost + "]";
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
