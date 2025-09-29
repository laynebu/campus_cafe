package campus_cafe.data;

import campus_cafe.model.*;
import java.math.BigDecimal;
import java.util.*;

public class Menu {
	private List<Product> items = new ArrayList<>();
	
	public Menu() {
		BuildMenu();
	}
	
	private void BuildMenu() {
		Beverage bev = new Beverage("B01", "Coffee", BigDecimal.valueOf(2.50), "Beverage");
		items.add(bev);
		
		bev = new Beverage("B02", "Tea", BigDecimal.valueOf(3.50), "Beverage");
		items.add(bev);
		
		bev = new Beverage("B03", "Orange Juice", BigDecimal.valueOf(5.00), "Beverage");
		items.add(bev);
		
		Food food = new Food("F01", "Bagel", BigDecimal.valueOf(3.25), "Food");
		items.add(food);
		
		food = new Food("F02", "Breakfast Sandwich", BigDecimal.valueOf(8.35), "Food");
		items.add(food);
		
		
	}
	public void DisplayMenu() {
		System.out.println("Welcome to the Campus Cafe\n");
		System.out.println("Please select from the following . . .");
		
		for(Product item : items ) {
			System.out.println(String.format("%s -- %s: $%.2f",
					item.getId(), item.getName(), item.getBasePrice()));
		}
	}
	public Product findItem(String id) {
	    for (Product item : items) {
	        if (item.getId().equalsIgnoreCase(id)) {
	            return item;
	        }
	    }
	    return null;
	}
}
