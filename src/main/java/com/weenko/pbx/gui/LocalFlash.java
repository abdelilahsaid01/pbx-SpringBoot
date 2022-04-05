package com.weenko.pbx.gui;

public class LocalFlash {
String code = "";
String type = "";
String arg1 = "", arg2 = "";
public LocalFlash(String code, String type, String arg1, String arg2) {
	super();
	this.code = code;
	this.type = type;
	this.arg1 = arg1;
	this.arg2 = arg2;
}
public LocalFlash(String code, String type, String arg1) {
	super();
	this.code = code;
	this.type = type;
	this.arg1 = arg1;
}
public LocalFlash(String code, String type) {
	super();
	this.code = code;
	this.type = type;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getArg1() {
	return arg1;
}
public void setArg1(String arg1) {
	this.arg1 = arg1;
}
public String getArg2() {
	return arg2;
}
public void setArg2(String arg2) {
	this.arg2 = arg2;
}

@Override
public String toString() {
	return type+"("+code+", "+arg1+", "+arg2+")";
}


}
