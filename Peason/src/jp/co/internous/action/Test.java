package jp.co.internous.action;

public class Test {

	public static void main(String[] args){
		Person taro=new Person();
		taro.name="山田太郎";
		taro.age=20;
		taro.phoneNumber="090";
		taro.address="taro@gmail.com";

		System.out.println(taro.name);
		System.out.println(taro.age);
		System.out.println(taro.phoneNumber);
		System.out.println(taro.address);
		taro.talk();
		taro.walk();

		Person jiro=new Person();
		jiro.name="木村次郎";
		jiro.age=18;
		jiro.phoneNumber="090";
		jiro.address="jiro@gmail.com";

		System.out.println(jiro.name);
		System.out.println(jiro.age);
		System.out.println(jiro.phoneNumber);
		System.out.println(jiro.address);

		Person hanako=new Person();
		hanako.name="鈴木花子";
		hanako.age=16;
		hanako.phoneNumber="090";
		hanako.address="hanako@gmail.com";

		System.out.println(hanako.name);
		System.out.println(hanako.age);
		System.out.println(hanako.phoneNumber);
		System.out.println(hanako.address);

		Person miyu=new Person();
		miyu.name="直島美夢";
		miyu.age=23;
		miyu.phoneNumber="090";
		miyu.address="miyu@gmail.com";

		System.out.println(miyu.name);
		System.out.println(miyu.age);
		System.out.println(miyu.phoneNumber);
		System.out.println(miyu.address);





	}

}
