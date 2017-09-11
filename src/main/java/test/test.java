package test;

public class test {

	
	public static void main(String[] args){
		
		bathroom b = new bathroom();
		b.setMirrors(3);
		House h = new House(b);
		h.Color();
		System.out.println(h.b.getMirrors());
	}
	
}
