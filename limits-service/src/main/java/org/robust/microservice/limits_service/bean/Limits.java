package org.robust.microservice.limits_service.bean;

public class Limits {

	private int min;
	private int max;
	
	public Limits() {
		
	}
	
	public Limits(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}

	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	
	
}
