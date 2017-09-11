package test;

public class testCar {
	
	
	public static void main(String[] args){
		
		car c = new car();
		c.carModel = "BMW";
		
		c.reg = new registeration_no();
		c.reg.regNo = "DL 12345";
		
		System.out.println(c.reg.regNo);
		
	}
	

	
	

}
