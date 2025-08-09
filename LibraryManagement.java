import java.util.*;

class Book {
    private String title;
    private String author;
    private boolean isIssued;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void issueBook() {
        isIssued = true;
    }

    public void returnBook() {
        isIssued = false;
    }

    public void displayBook() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author); 
        System.out.println("Issued: " + isIssued);
    }
}

class User {
    private String name;
    private int userId;

    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public int getUserId() {
        return userId;
    }

    public void displayUser() {
        System.out.println("Username: " + name);
        System.out.println("UserId: " + userId);
    }
}

class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user.getName());
    }

    public boolean isValidUser(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }

    public void issueBook(int userId, String title) {
        // First check user existence
        if (!isValidUser(userId)) {
            System.out.println("Error: User ID " + userId + " does not exist.");
            return;
        }

        // Then check book existence
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isIssued()) {
                    book.issueBook();
                    System.out.println("Book '" + title + "' issued to User ID " + userId);
                } else {
                    System.out.println("Book '" + title + "' is already issued.");
                }
                return;
            }
        }

        System.out.println("Book titled '" + title + "' not found.");
    }

    public void returnBook(String title, int userId) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isIssued()) {
                book.returnBook();
                System.out.println("Book '" + title + "'  returned by User ID " + userId);
                return;
            }
        }
        System.out.println("Book was not issued or does not exist.");
    }

    public void displayAllBooks() {
        System.out.println("\n--- All Books ---");
        int count = 1;
        for (Book book : books) {
            System.out.println("\nBook " + count + ":");
            book.displayBook();
            count++;
        }
    }

    public void displayAllUsers() {
        System.out.println("\n--- All Users ---");
        int count = 1;
        for (User user : users) {
            System.out.println("\nUser " + count + ":");
            user.displayUser();
            count++;
        }
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Adding sample books
        library.addBook(new Book("Introduction to Algorithms", "Thomas H. Cormen"));
        library.addBook(new Book("Clean Code", "Robert C. Martin"));
        library.addBook(new Book("Design Patterns", "Erich Gamma"));
        library.addBook(new Book("Artificial Intelligence: A Modern Approach", "Stuart Russell"));
        library.addBook(new Book("Operating System Concepts", "Abraham Silberschatz"));
        library.addBook(new Book("Database System Concepts", "Abraham Silberschatz"));
        library.addBook(new Book("Computer Networking: A Top-Down Approach", "James F. Kurose"));
        library.addBook(new Book("The Pragmatic Programmer", "Andrew Hunt"));  

        // Adding sample users
        library.addUser(new User("Ram", 101));
        library.addUser(new User("Sree", 102));
        library.addUser(new User("Sai", 103));
        library.addUser(new User("Sam", 104));

        int choice;
        do {
            System.out.println("\n----- Library Menu -----");
            System.out.println("1. Display all books");
            System.out.println("2. Display all users");
            System.out.println("3. Issue book");
            System.out.println("4. Return book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    library.displayAllBooks();
                    break;
                case 2:
                    library.displayAllUsers();
                    break;
                case 3:
                    System.out.print("Enter user ID: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    // Check user first before asking book title
                    if (!library.isValidUser(userId)) {
                        System.out.println("Error: User ID " + userId + " does not exist.");
                        break; // go back to menu
                    }

                    System.out.print("Enter book title to issue: ");
                    String issueTitle = scanner.nextLine();
                    library.issueBook(userId, issueTitle);
                    break;
                case 4:
                    System.out.print("Enter user ID: ");
                    int returnUserId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter book title to return: ");
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle,returnUserId);
                    break;
                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        scanner.close();
    }
}