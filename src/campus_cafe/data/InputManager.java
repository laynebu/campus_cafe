package campus_cafe.data;

import java.util.Scanner;

import campus_cafe.model.Product;

import java.util.*;

public class InputManager {
	public List<String> modifiers = new ArrayList<>();

	public List<Product> getOrder() {
		Menu menu = new Menu();
		Scanner sc = new Scanner(System.in);
		List<Product> orderItems = new ArrayList<>();

		
		while (true) {
            System.out.print("\nEnter the id for item or 'done': ");
            String input = sc.nextLine();
            String size = null;
        	String quantity;
        	String foodmods = null;
            if (input.equalsIgnoreCase("done")) {
                break;
            }

            Product item = menu.findItem(input);
            if (item != null) {
                orderItems.add(item);
                System.out.println(item.getName() + " added to your order.");
                if (item.getType().equals("Beverage")) {
                	System.out.println("Size, S/M/L:");
                	size = sc.nextLine();
                	size = size.toUpperCase();
                	if (size.equals("S") || size.equals("M") || size.equals("L")) {
                		
                	}
                	else {
                		System.out.println("Invalid Option, Size Defaulted to S.");
                		size = "S";
                	}
                }
                if (item.getType().equals("Food")) {
                	System.out.println("Modifications? (XCH: (extra cheese) or GF: (Gluten Free) or BOTH:");
                	foodmods = sc.nextLine();
                	foodmods = foodmods.toUpperCase();
                	if (foodmods.equals("XCH") || foodmods.equals("GF") || foodmods.equals("BOTH")) {
                		
                	}
                	else {
                		System.out.println("Invalid Option, No modifications applied.");
                		
                	}
                }
                System.out.println("Quantity: ");
                quantity = sc.nextLine();
                if (Integer.parseInt(quantity) > 0) {
                	
                }
                else {
                	System.out.println("Invalid Quantity, Quanity is set to 1.");
                	quantity = "1";
                }
                modifiers.add(size + " " + quantity + " " + foodmods);
            } else {
                System.out.println("Invalid ID. Please try again.");
            }
        }
		sc.close();
		return orderItems;
	}
	public List<String> getModifiers(){
		return modifiers;
	}
}
