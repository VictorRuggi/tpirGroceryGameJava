import javax.swing.*;
import java.util.*;
import java.math.*;

public class TPIRGroceryGame {
	public static void main(String[] args) {
		ArrayList<GroceryItem> groceryItems = new ArrayList<GroceryItem>(); //Total Grocery Items this game can pick from.

		groceryItems.add( new GroceryItem("cereal", "525 gram box of Shredded Wheat cereal, high in fiber and sugar free", new BigDecimal(Math.random()*2 + 2, new MathContext(3))) );
		groceryItems.add( new GroceryItem("corn syrup", "1 liter bottle of No Name corn syrup", new BigDecimal(Math.random()*2 + 4, new MathContext(3))) );
		groceryItems.add( new GroceryItem("cheese strings", "168 gram pack of Black Diamond cheese strings", new BigDecimal(Math.random()*2 + 3, new MathContext(3))) );
		groceryItems.add( new GroceryItem("water bottle", "1.5 liter bottle of President's Choice natural spring water", new BigDecimal(Math.random() + 0.7, new MathContext(3))) );
		groceryItems.add( new GroceryItem("orange juice", "1.75 liter bottle of President's Choice orange juice with pulp", new BigDecimal(Math.random()*2 + 1.6, new MathContext(3))) );
		groceryItems.add( new GroceryItem("peanut butter", "500 gram jar of smooth peanut butter from Jif", new BigDecimal(Math.random() + 2.5, new MathContext(3))) );
		groceryItems.add( new GroceryItem("soup", "540 milliliter can of Campbell's Italian Wedding soup", new BigDecimal(Math.random() + 1, new MathContext(3))) );
		groceryItems.add( new GroceryItem("ginger ale", "500 milliliter bottle of Canada Dry ginger ale", new BigDecimal(Math.random()*2 + 1.3, new MathContext(3))) );
		groceryItems.add( new GroceryItem("green peas", "284 milliliter can of Green Giant green peas", new BigDecimal(Math.random() + 0.8, new MathContext(3))) );
		groceryItems.add( new GroceryItem("mayonnaise", "750 milliliter bottle of Hellmann's mayonnaise", new BigDecimal(Math.random()*2 + 3, new MathContext(3))) );
		groceryItems.add( new GroceryItem("granola bars", "210 gram box of Nature Valley granola bars", new BigDecimal(Math.random() + 3.2, new MathContext(3))) );
		groceryItems.add( new GroceryItem("worcestershire sauce", "295 milliliter bottle of French's Worcestershire sauce", new BigDecimal(Math.random() + 3.2, new MathContext(3))) );
		groceryItems.add( new GroceryItem("noodle mix", "200 gram box of Betty Crocker Hamburger Helper noodle mix", new BigDecimal(Math.random() + 2.1, new MathContext(3))) );
		groceryItems.add( new GroceryItem("vinegar", "500 milliliter bottle of President's Choice vinegar", new BigDecimal(Math.random()*2 + 3, new MathContext(3))) );
		groceryItems.add( new GroceryItem("kettle chips", "45 gram bag of Kettle brand potato chips", new BigDecimal(Math.random() + 0.6, new MathContext(3))) );
		groceryItems.add( new GroceryItem("couscous", "907 gram bag of Clic brand couscous", new BigDecimal(Math.random() + 3.6, new MathContext(3))) );
		groceryItems.add( new GroceryItem("milkshake drink", "473 milliliter bottle of Coffee Crisp chocolate flavored milkshake drink", new BigDecimal(Math.random() + 1, new MathContext(3))) );
		groceryItems.add( new GroceryItem("brownie mix", "450 gram box of Duncan Hines brownie mix", new BigDecimal(Math.random() + 2.2, new MathContext(3))) );
		groceryItems.add( new GroceryItem("iced tea", "2 liter bottle of Lipton Brisk iced tea", new BigDecimal(Math.random() + 1, new MathContext(3))) );
		groceryItems.add( new GroceryItem("waffles", "280 gram box of 8 Eggo waffles", new BigDecimal(Math.random()*1.4 + 2, new MathContext(3))) );
		groceryItems.add( new GroceryItem("mushrooms", "227 gram box of President's Choice white mushrooms", new BigDecimal(Math.random() + 1.6, new MathContext(3))) );

		/*FORMATTING*/
		for(int i=0;i<groceryItems.size();i++){
			if(groceryItems.get(i).getItemPrice().compareTo(new BigDecimal("1.00")) < 1 ){
				groceryItems.get(i).getItemPrice().round(new MathContext(2));
			}
		}

		int guesses = 0; //Maximum 5 guesses or until player is within range or until player goes over
		int quantity = 0;
		BigDecimal total = new BigDecimal("0.00");

		ArrayList<GroceryItem> itemsInGame = new ArrayList<GroceryItem>(); //These will be the items in this game
		boolean won=false;

		int picker; //Finder
		BigDecimal itemPrice=null; //Getter

		for(int i=0;i<5;i++){
			//Add an item, then remove it from the original list
			picker = (int)(Math.random() * groceryItems.size());
			itemsInGame.add(i, groceryItems.get(picker));
			groceryItems.remove(picker);
		}

		System.out.println("THE PRICE IS RIGHT - GROCERY GAME\nFinish with a total between $20 and $22 by purchasing these common grocery items to win!\nThese are the items on display today. They are as follows:\n");
		for(int i=0;i<itemsInGame.size();i++){
			System.out.println(itemsInGame.get(i).getItemName() + "\n" + itemsInGame.get(i).getDesc() + "\n");
		}

		try {
			//If at any point in the game your total is between $20 and $22, you win!
			//But you can lose the game in the following ways: if you go over $22, or if you use up all five items and come up short of $20-$22.
			while(guesses < 5 && total.compareTo(new BigDecimal("20.00")) < 20){
				String inputItem = JOptionPane.showInputDialog("Of the items on display, name one that you would like to purchase.").toLowerCase();

				/*POPULAR REPLACEMENTS*/
				inputItem = inputItem.replaceAll("canada dry", "ginger ale");
				inputItem = inputItem.replaceAll("hamburger helper", "noodle mix");
				inputItem = inputItem.replaceAll("eggo", "waffles");
				inputItem = inputItem.replaceAll("eggos", "waffles");

				String inputQuantity = JOptionPane.showInputDialog("Enter the quantity of this item that you would like to purchase, minimum 1");
				quantity = Integer.parseInt(inputQuantity);

				for(int i=0;i<itemsInGame.size();i++){
					if(itemsInGame.get(i).getItemName().indexOf(inputItem) != -1){
						itemPrice = itemsInGame.get(i).getItemPrice();
						total = total.add( itemPrice.multiply(new BigDecimal(quantity, new MathContext(3))) );
						itemsInGame.remove(i);
					}
				}

				System.out.println("You ordered " + quantity + " " + inputItem + ", worth $" + itemPrice.multiply( new BigDecimal(quantity) ) + ".\nYour total is: $" + total + "\nYou have " + (5-(guesses+1)) + " guesses remaining.\n");

				if(total.doubleValue() < 20){
					guesses++;
				}
				else {
					break;
				}
			}

			if(total.doubleValue() >= 20 && total.doubleValue() <= 22) {
				won = true;
				System.out.println("Congratulations, you win!");
			}
			else {
				if (total.doubleValue() > 22){
					won = false;
					System.out.println("You went over $22. Sorry, you lose.");
				}
				else if (guesses == 5 && total.doubleValue() < 20){
					won = false;
					System.out.println("You used up all five items and came up short of $20-$22. Sorry, you lose.");
				}
				else if (guesses == 5 && total.doubleValue() > 22){
					won = false;
					System.out.println("You used up all five items and went over $20-$22. Sorry, you lose.");
				}
				else if (guesses == 5 && total.doubleValue() >= 20 && total.doubleValue() <= 22){
					won = true;
					System.out.println("Congratulations, you win!");
				}
			}
		}
		catch (Exception e) {
			System.out.println("Inputted invalid data. Game over");
		}
	}
}