package com.holy.sboot.origin.basic;

public class JsonResponseMsg<T> {

	private T data;
	private String flag;
	public static final String FLAG_OK = "OK";
	public static final String FLAG_ERROR = "ERROR";

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public static <K> JsonResponseMsg<K> createSuccessResponseMsg() {
		JsonResponseMsg<K> jrm = new JsonResponseMsg<>();
		jrm.setFlag(FLAG_OK);
		return jrm;
	}

	public static <K> JsonResponseMsg<K> createErrorResponseMsg() {
		JsonResponseMsg<K> jrm = new JsonResponseMsg<>();
		jrm.setFlag(FLAG_ERROR);
		return jrm;
	}

	public static <K> JsonResponseMsg<K> createResponseMsg(K data) {
		JsonResponseMsg<K> jrm = new JsonResponseMsg<>();
		jrm.setData(data);
		jrm.setFlag(FLAG_OK);
		return jrm;
	}

	public static JsonResponseMsg<String> createResponseMsg(int row) {
		JsonResponseMsg<String> jrm = new JsonResponseMsg<>();
		String rr = row > 1 ? " rows" : " row";
		jrm.setData(row + rr + " affected");
		jrm.setFlag(FLAG_OK);
		return jrm;
	}
}
