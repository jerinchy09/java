package design.patterns;

import java.util.Scanner;

public class Client {

    private static SearchResource searchResource = SearchResource.getInstance();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Do you want to search by: ");
                System.out.println("1. First Name");
                System.out.println("2. Last Name");
                System.out.println("3. Exit");

                String choice = input.nextLine();

                if ("3".equalsIgnoreCase(choice)) {
                    break;
                }

                switch (Integer.valueOf(choice)) {
                    case 1:
                        System.out.println("Please enter the first name you want to search for");
                        String fname = input.nextLine();
                        System.out.println(searchResource.getCustomerByFirstName(fname));
                    break;

                    case 2:
                        System.out.println("Please enter the last name you want to search for");
                        String lname = input.nextLine();
                        System.out.println(searchResource.getCustomerByLastName(lname));
                    break;

                    default:
                        System.out.println("Input did not match any menu items");
                        continue;
                }
            } catch (Exception e) {
                System.out.println("Something went wrong. Try again.");
            }
        }
    }
}
