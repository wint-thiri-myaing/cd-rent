package com.vlm.cdmodal;

public class Usermodal {
int id;
String name;
String password;
int loginflag;
public Usermodal(int id, String name, String password, int loginflag) {
	super();
	this.id = id;
	this.name = name;
	this.password = password;
	this.loginflag = loginflag;
}

public Usermodal(String name, String password) {
	super();
	this.name = name;
	this.password = password;
}

public Usermodal() {
	// TODO Auto-generated constructor stub
}

public int getLoginflag() {
	return loginflag;
}
/**
 * @param loginflag the loginflag to set
 */
public void setLoginflag(int loginflag) {
	this.loginflag = loginflag;
}
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
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
