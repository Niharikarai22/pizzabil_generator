import java.util.ArrayList;
import java.util.Scanner;

class Pizza {
    private String type;
    private String crust;
    private String size;
    private ArrayList<String> toppings;

    public Pizza(String type, String crust, String size, ArrayList<String> toppings) {
        this.type = type;
        this.crust = crust;
        this.size = size;
        this.toppings = toppings;
    }

    public String getType() {
        return type;
    }

    public String getCrust() {
        return crust;
    }

    public String getSize() {
        return size;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public double calculateCost() {
        double cost = 0.0; 
        if (type.equalsIgnoreCase("veg")) {
            cost += 8.99;
        } else if (type.equalsIgnoreCase("non-veg")) {
            cost += 11.99;
        }
        if (crust.equalsIgnoreCase("thin")) {
            cost += 1.99;
        } else if (crust.equalsIgnoreCase("pan")) {
            cost += 2.99;
        } else if (crust.equalsIgnoreCase("stuffed")) {
            cost += 3.99;
        }
        if (size.equalsIgnoreCase("small")) {
            cost += 2.99;
        } else if (size.equalsIgnoreCase("medium")) {
            cost += 4.99;
        } else if (size.equalsIgnoreCase("large")) {
            cost += 6.99;
        }
        cost += toppings.size() * 0.99;
        return cost;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the type of pizza (veg or non-veg): ");
        String type = scanner.nextLine();

        System.out.print("Enter the crust of pizza (thin, pan, or stuffed): ");
        String crust = scanner.nextLine();

        System.out.print("Enter the size of pizza (small, medium, or large): ");
        String size = scanner.nextLine();

        ArrayList<String> toppings = new ArrayList<String>();
        System.out.println("Enter the toppings of pizza (type 'done' when finished): ");
        while (true) {
            String topping = scanner.nextLine();
            if (topping.equalsIgnoreCase("done")) {
                break;
            }
            toppings.add(topping);
        }

        Pizza pizza = new Pizza(type, crust, size, toppings);

        System.out.println("Is the pizza for dine-in or take-out?");
        String orderType = scanner.nextLine();

        boolean paperBag = false;
        if (orderType.equalsIgnoreCase("take-out")) {
            System.out.println("Do you need a paper bag? (yes or no)");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("yes")) {
                paperBag = true;
            }
        }

        System.out.println("Your order summary:");
        System.out.println("Pizza type: " + pizza.getType());
        System.out.println("Pizza crust: " + pizza.getCrust());
        System.out.println("Pizza size: " + pizza.getSize());
        System.out.println("Pizza toppings: " + pizza.getToppings());
        System.out.println("Total cost: $" + pizza.calculateCost());
// Ask the user if they want to remove any toppings from the pizza
        System.out.print("Do you want to remove any toppings? (yes or no): ");
        String removeToppings = scanner.nextLine();
        if (removeToppings.equalsIgnoreCase("yes")) {
            // Display the current toppings of the pizza
            System.out.println("Current toppings: " + pizza.getToppings().toString());

            // Ask the user which topping they want to remove
            System.out.print("Enter the topping you want to remove: ");
            String toppingToRemove = scanner.nextLine();

            // Remove the topping from the pizza
            if (pizza.getToppings().contains(toppingToRemove)) {
                pizza.getToppings().remove(toppingToRemove);
                System.out.println(toppingToRemove + " has been removed from the pizza.");
            } else {
                System.out.println("The topping you entered is not on the pizza.");
            }
        }

// Display the final pizza details and cost
        System.out.println("\nYour pizza details:");
        System.out.println("Type: " + pizza.getType());
        System.out.println("Crust: " + pizza.getCrust());
        System.out.println("Size: " + pizza.getSize());
        System.out.println("Toppings: " + pizza.getToppings().toString());
        System.out.printf("Total cost: $%.2f\n", pizza.calculateCost());

// Ask the user if they want a paper bag for take-out orders
        if (type.equalsIgnoreCase("non-veg") && orderType.equalsIgnoreCase("take-out")) {
            System.out.print("Do you want a paper bag? (yes or no): ");
            String paperBa = scanner.nextLine();
            if (paperBa.equalsIgnoreCase("yes")) {
                System.out.println("A paper bag will be added to your order.");
            }
        }

// Thank the user for their order
        System.out.println("Thank you for your order! Enjoy your pizza.");
    }
}
      
