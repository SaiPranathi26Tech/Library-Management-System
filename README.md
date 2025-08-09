# 📚 Java Library Management System

## 📘 Overview
This project is a **console-based library management system** developed in Java.  
It provides an interactive, menu-driven interface to manage books and users,  
allowing the issuing and returning of books while validating users and book availability.  

The system uses **Java's ArrayList** to store `Book` and `User` objects dynamically.  
It follows **object-oriented programming principles** with a clean, modular structure,  
making it an excellent project for beginners to understand **OOP, collections, and input handling**.

---

## ✨ Features

### 🔹 Core Functionalities
- **Add Books & Users**: Preloaded with a sample list of computer science books and users.
- **Display Books**: Lists all available books with their details and issued status.
- **Display Users**: Lists all registered users with their IDs.
- **Issue Book**: Issues a book to a valid user, checking if the book exists and is not already issued.
- **Return Book**: Returns a previously issued book and displays the user ID that returned it.

### 🛡️ Input Handling and Safety
- Validates **User ID** before allowing issuing or returning of books.
- Validates **Book Title** before issuing or returning.
- Prevents issuing of already-issued books.
- Displays appropriate error messages for invalid inputs.

---

## 🔁 Program Flow
The program runs in a continuous loop until the user chooses to exit.  
It presents a numbered menu to the user and uses a `switch-case` statement to execute operations.

Each major operation is implemented in its own **class method** for clarity and modularity:

- `addBook(Book book)`
- `addUser(User user)`
- `displayAllBooks()`
- `displayAllUsers()`
- `issueBook(int userId, String title)`
- `returnBook(String title, int userId)`

---

## 💻 Technologies Used

| Technology | Purpose |
|------------|---------|
| Java (JDK 17) | Programming language |
| VS Code | IDE used for development |
| Terminal / Console | Running and testing the program |
| java.util.* | Using `Scanner`, `ArrayList` |

---

## 🎯 Learning Outcomes
By building this project, you will reinforce:
- **Object-Oriented Programming (OOP)** concepts (Encapsulation, Classes, Objects)
- **Collections in Java** (`ArrayList`)
- **Conditional logic** (`if`, `switch`)
- **Looping constructs** (`while`, `for-each`)
- **User input validation** and error handling

---

## 👩‍💻 Author
**Thirakala Sai Pranathi**  
An aspiring software developer passionate about creating practical applications and deepening programming skills through hands-on projects.

---

## 🚀 Future Improvements
- Implement search functionality for books and users.
- Allow adding/removing books and users dynamically.
- Track book issue dates and due dates.
- Store and load records from files (**File I/O**).
- Create a GUI version using **JavaFX** or **Swing**.

---

## 📝 License
This project is provided for educational purposes.  
You are free to use, modify, and enhance it for your own learning or academic work.

