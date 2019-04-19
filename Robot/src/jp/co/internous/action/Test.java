package jp.co.internous.action;

public class Test {
	
	public static void main(String[]args){
		Robot aibo=new Robot();
		aibo.name="aibo";
		
		System.out.println(aibo.name);
		aibo.walk();
		aibo.talk();
		aibo.run();		
	
		
		Robot asimo=new Robot();
		asimo.name="asimo";
		
		System.out.println(asimo.name);
		asimo.walk();
		asimo.talk();
		asimo.run();
	
		
		Robot pepper=new Robot();
		pepper.name="pepper";
				
		System.out.println(pepper.name);
		pepper.walk();
		pepper.talk();
		pepper.run();
		
	}

}
