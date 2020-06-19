package com.qht.io.zs;

public class Test01 {

	public static void main(String[] args) {
		Drink coffee = new Coffee();
		Milk de = new Milk(coffee);
		System.out.println(de.cost()+"-->"+de.info());
		
		Sugar a = new Sugar(de);
		System.out.println(a.cost()+"-->"+a.info());
	}
}

interface Drink{
	double cost();//费用
	String info();//说明
}

class Coffee implements Drink{

	String name = "原味奶茶";
	@Override
	public double cost() {
		return 10;
	}

	@Override
	public String info() {
		return name;
	}
	
}
abstract class Decorate implements Drink{

	private Drink drink;
	
	public Decorate(Drink drink) {
		this.drink = drink;
	}
	@Override
	public double cost() {
		
		return drink.cost();
	}

	@Override
	public String info() {
		
		return drink.info();
	}
	
}

class Milk extends Decorate{

	public Milk(Drink drink) {
		super(drink);
	}
	
	public double cost() {
		
		return super.cost()*4;
	}

	
	public String info() {
		
		return super.info()+"加了牛奶";
	}
	
	
}

class Sugar extends Decorate{

	public Sugar(Drink drink) {
		super(drink);
	}
	
	public double cost() {
		
		return super.cost()*2;
	}

	
	public String info() {
		
		return super.info()+"加了糖";
	}
	
	
}
