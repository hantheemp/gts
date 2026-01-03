package com.muratkagan.gts.dto;

public class APIResponse {
	private String status;
	private int resultCode;
	private String resultMessage;
	private Object resultData;

	public APIResponse(String status, int resultCode, String resultMessage) {
		this(status, resultCode, resultMessage, null);
	}

	public APIResponse(String status, int resultCode, String resultMessage, Object resultData) {
		this.status = status;
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
		this.resultData = resultData;
	}

	// Getters and setters
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public Object getResultData() {
		return resultData;
	}

	public void setResultData(Object resultData) {
		this.resultData = resultData;
	}
}