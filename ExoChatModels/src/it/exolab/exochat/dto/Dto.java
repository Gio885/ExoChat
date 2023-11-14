package it.exolab.exochat.dto;

import java.io.Serializable;

public class Dto <T> implements Serializable {

	private static final long serialVersionUID = 8883478350563781119L;
	
	
	private Object data;
	private boolean success;
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
		this.success = true;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}

	
	
	
	
}
