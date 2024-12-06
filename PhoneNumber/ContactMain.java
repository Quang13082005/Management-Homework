import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Contact> contactList = new ArrayList<>();
        int choice;
        do {
            System.out.println("1. Add people to contacts.");
            System.out.println("2. Search for people by name.");
            System.out.println("3. Show all contacts in address book.");
            System.out.println("4. Delete a contact selected by the user.");
            System.out.println("5. Exit program.");
            System.out.println("Enter your choice");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Add information people you want");
                    addPeople(contactList);
                    break;
                case 2:
                    searchPeople(contactList);
                    break;
                case 3:
                    showInformation(contactList);
                    break;
                case 4:
                    showInformation(contactList);
                    deletePeople(contactList);
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        } while (choice != 5);
    }

    public static void addPeople(List<Contact> contactList) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter contact name: ");
        String name = sc.nextLine();

        System.out.print("Enter phone number: ");
        int phoneNumber = sc.nextInt();


        Contact contact = new Contact(name, phoneNumber);
        contactList.add(contact);

    }

    public static void searchPeople(List<Contact> contactList) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the name you want to search: ");
        String name = sc.nextLine();
        boolean isContactFound = false;
        for (Contact num : contactList) {
            if (num.getName().equals(name)) {
                isContactFound = true;
                System.out.println(num);
                break;
            }
        }
        if (!isContactFound) {
            System.out.println("Don't have " + name + " on the list");
        }

    }

    public static void deletePeople(List<Contact> contactList) {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("select one option");
        System.out.println("1. Delete by id");
        System.out.println("2. Delete by name");
        System.out.println("Enter your choice: ");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter Your id you want to Delete: ");
                int number = sc.nextInt();
                if (number > 0 && number <= contactList.size()) {
                    contactList.remove(number - 1);
                    System.out.println("Deleted successfully");
                } else {
                    System.out.println("Does not exist");
                }
                break;
            case 2:
                System.out.println("Enter Your name you want to Delete: ");
                sc.nextLine();
                String name = sc.nextLine();
                boolean isDelete = false;
                for (Contact num : contactList) {
                    if (num.getName().equals(name)) {
                        isDelete = true;
                        contactList.remove(num);
                        System.out.println("Deleted successfully ");
                        break;
                    }
                }
                if (!isDelete) {
                    System.out.println("Does not exist");
                }

        }

    }

    public static void showInformation(List<Contact> contactList) {
        System.out.println("Display All Contacts");
        for (int i = 0; i < contactList.size(); i++) {
            System.out.println((i + 1) + ". " + contactList.get(i));
        }
    }
}

