
import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    // public String name;
    // public String address;
    ArrayList<book> books;
    ArrayList<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "Enter id,title,name,author,genre");
        int id = scanner.nextInt();
        scanner.nextLine();
        String title = scanner.nextLine();
        String Name = scanner.nextLine();
        String author = scanner.nextLine();
        String genre = scanner.nextLine();
        book b = new book(id, title, Name, author, genre, 1);
        books.add(b);
        System.out.println("\nBook added successfully");
        // scanner.close();
    }

    public void issueBook(int bookID, int memberID, String bookName) {
        boolean bookFound = false;
        boolean memberFound = false;

        for (book b : books) {
            if (b.id == bookID && b.copiesAvailable > 0) {
                bookFound = true;
                for (Member m : members) {
                    if (m.memberID == memberID) {
                        b.copiesAvailable--;
                        memberFound = true;
                        m.bookOwned.add(bookName);
                        System.out.println("Book issued to member " + memberID);
                        return;
                    }
                }
                if (!memberFound) {
                    System.out.println("Member with ID " + memberID + " not found.");
                }
                return;
            }
        }
        if (!bookFound) {
            System.out.println("Book with ID "
                    + bookID + " not found or no copies available.");
        }
    }

    public void returnBook(int bookID, int memberID, String bookname) {
        boolean bookFound = false;
        boolean memberFound = false;
        for (book b : books) {
            if (b.id == bookID) {
                bookFound = true;
                b.copiesAvailable++;
                for (Member m : members) {
                    if (m.memberID == memberID) {
                        memberFound = true;
                        for (int i = 0; i < m.bookOwned.size(); i++) {
                            if (m.bookOwned.get(i).equals(bookname)) {
                                m.bookOwned.remove(i);
                            }
                        }
                    }
                }
                if (!memberFound) {
                    System.out.println("\nMember didn't match");
                    return;
                }
            }
        }
        if (!bookFound) {
            System.out.println("\nBook not found");
        }
        if (bookFound && memberFound) {
            System.out.println("Book successfully returned by ID: " + memberID);
        }
    }

    public void addMember() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name, address,email,memberID,membertype");
        String Name = scanner.nextLine();
        String Address = scanner.nextLine();
        String email = scanner.nextLine();
        int memberId = scanner.nextInt();
        scanner.nextLine();
        String memberType = scanner.nextLine();
        Member m = new Member(Name, Address, email, memberId, memberType);
        members.add(m);
        System.out.println("\nMember : \"" + m.name + "\" added successfully");

    }

    public void searchBook(int bookID) {
        boolean found = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).id == bookID) {
                found = true;
                System.out.println("\nBook Found");
                books.get(i).displayInfo();
            }
            if (!found) {
                System.out.println("\nBook not found");
            }
        }
    }

    public void view_members() {
        if (members.isEmpty()) {
            System.out.println("\nNo member has beed enrolled yet");
        }

        for (int i = 0; i < members.size(); i++) {
            members.get(i).display();
        }
    }
}
