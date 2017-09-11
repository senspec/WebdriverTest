package test;

public class House extends building {
	
	//House is a Building - inheritance
	//House has a bathroom - encapsulation
	
	bathroom b = null;
	
	public House(bathroom b){
		
		this.b = b;
	}

}
