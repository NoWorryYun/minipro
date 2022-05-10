package com.javaex.phonebook;

public class Person {


	//필드
	private String name;
	private String hp;
	private String company;
	
	
	//생성자
	public Person() {}
	public Person(String name, String hp, String company) {
		this.name = name;
		this.hp = hp;
		this.company = company;
	}

	
	
	//GS
	public String getName() {
		return name;
	}
	public String getHp() {
		return hp;
	}
	public String getCompany() {
		return company;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	
	
	//일반
	public void showInfo() {
		System.out.println(this.name+ "   " + this.hp + "   " + this.company);
	}
	
	
}
