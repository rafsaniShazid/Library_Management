
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int bookID, memberID;
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        Library lib = new Library();
        while (choice != 7) {
            System.out.println("""
                        \nWelcome to the Library Management System
                           
                           1. Add a Book
                           2. Register a Member
                           3. Issue a Book
                           4. Return a Book
                           5. Search for a Book
                           6. View All Members
                           7. Exit
                           """);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    lib.addBook();
                    break;
                case 2:
                    lib.addMember();
                    break;
                case 3:
                    System.out.println("Enter bookID,memberId,bookname");
                    bookID = scanner.nextInt();
                    scanner.nextLine();
                    memberID = scanner.nextInt();
                    scanner.nextLine();
                    String bookname = scanner.nextLine();
                    lib.issueBook(bookID, memberID, bookname);
                    break;
                case 4:
                    System.out.println("Enter bookID,memberId,bookname");
                    bookID = scanner.nextInt();
                    scanner.nextLine();
                    memberID=scanner.nextInt();
                    scanner.nextLine();
                    bookname= scanner.nextLine();
                    lib.returnBook(bookID, memberID,bookname);
                    break;
                case 5:
                    System.out.println("Enter bookID");
                    bookID = scanner.nextInt();
                    lib.searchBook(bookID);
                    break;
                case 6:
                    lib.view_members();
                    break;
                case 7:
                    System.out.println("Exiting the Library Management System");
                    break;
                default:
                    System.out.println("Invalid key");
            }
        }
        scanner.close();
    }
}
