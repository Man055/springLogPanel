package com.loginSection.spring;

public class jsonFit {
	private String msgType;
	private String msg;
	public jsonFit(String msgType,String msg){
		this.msgType  =msgType;
		this.msg =msg;
	}
	
	public void setKey(String msgType){
		this.msgType  =msgType;
	}
	public void setVal(String msg){
		this.msg  =msg;
	}
	public String getMsgType(){
		return msgType;
	}
	public String getMsg(){
		return msg;
	}
}
