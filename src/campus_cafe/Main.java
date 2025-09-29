package campus_cafe;

import campus_cafe.data.*;
import campus_cafe.model.*;

import java.util.*;
public class Main {

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.DisplayMenu();
		InputManager input = new InputManager();
		List<Product> order = input.getOrder();
		List<String> modifiers = input.getModifiers();
		Order newOrder = new Order();
		String receipt = newOrder.createOrder(order, modifiers);
		System.out.print(receipt);
		System.exit(0);
		
	}

}
