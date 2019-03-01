
class Food1 {
	
	protected String foodName;
	
	public Food1(String foodName) {
		this.foodName = foodName;
	}
	
	public void serveFood(){
		System.out.println("I am serving "+ foodName);
	}
	
	public Food1 getFood(String foodType){
		return new Food1(foodType);
	}
	
	public String getName(){
		return foodName;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Food ToString() called -"+foodName;
	}

}

class FoodFactory extends Food1{

	public FoodFactory(String foodName) {
		super(foodName);
	}
	
}

public class Food{
	public static void main(String[] args) {
		FoodFactory fc = new FoodFactory("");
		Food1 f1 = fc.getFood("FastFood");
		Food1 f2 = fc.getFood("Friuts");
		
		System.out.println("May name is "+f1.getClass().getName());
		System.out.println("May name is "+f1.getClass().getName());
		
		System.out.println("Our super is "+f1.getClass().getSuperclass().getName());
		
		f1.serveFood();
		f2.serveFood();
		
		Object f = new Food1("Sushil");
		
		System.out.println(f.toString());
		
	}
}
