package jp.co.internous.action;

public class Test {
	
	public static void main(String[]args){
		Person taro=new Person();
		taro.name="taro";
		taro.age=18;
		System.out.println(taro.name);
		System.out.println(taro.age);

	Person jiro=new Person("jiro",20);
	System.out.println(jiro.name);
	System.out.println(jiro.age);
	
	Person saburo=new Person();
	saburo.name="saburo";
	System.out.println(saburo.name);
	System.out.println(saburo.age);
	
	Person nanashi=new Person();
	nanashi.name="名前なし";
	nanashi.age=25;
	System.out.println(nanashi.name);
	System.out.println(nanashi.age);
	
	Person hanako=new Person();
	hanako.name="hanako";
	hanako.age=17;
	System.out.println(hanako.name);
	System.out.println(hanako.age);
	
	}

}
