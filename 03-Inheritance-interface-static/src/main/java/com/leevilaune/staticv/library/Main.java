package com.leevilaune.staticv.library;

import com.leevilaune.staticv.library.model.Book;
import com.leevilaune.staticv.library.model.LibraryMember;
import com.leevilaune.staticv.library.system.Library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Create books
        Book book1 = new Book("1984", "George Orwell", "ISBN-001");
        Book book2 = new Book("Brave New World", "Aldous Huxley", "ISBN-002");
        Book book3 = new Book("Fahrenheit 451", "Ray Bradbury", "ISBN-003");

        // Create members
        LibraryMember member1 = new LibraryMember("Alice", 1);
        LibraryMember member2 = new LibraryMember("Bob", 2);

        // Add books and members
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addMember(member1);
        library.addMember(member2);

        System.out.println("=== Initial Library State ===");
        System.out.println("Books in library: " + library.getBooks());
        System.out.println("Members in library: " + library.getMembers());

        // Borrowing
        System.out.println("\n=== Alice borrows 1984 ===");
        library.borrowBook(member1, book1);
        System.out.println("Books in library: " + library.getBooks());
        System.out.println("Alice's borrowed books: " + member1.getBorrowedBooks());

        // Reservation
        System.out.println("\n=== Bob reserves Brave New World ===");
        library.reserveBook(member2, book2);
        library.displayReservedBooks(member2);

        System.out.println("\n=== Alice tries to reserve Brave New World (already reserved) ===");
        library.reserveBook(member1, book2);
        library.displayReservedBooks(member1);

        // Cancel reservation
        System.out.println("\n=== Bob cancels reservation for Brave New World ===");
        library.cancelReservation(member2, book2);
        library.displayReservedBooks(member2);

        System.out.println("\n=== Alice reserves Brave New World (after Bob canceled) ===");
        library.reserveBook(member1, book2);
        library.displayReservedBooks(member1);

        // Invalid cancel
        System.out.println("\n=== Bob tries to cancel reservation he doesn’t have ===");
        library.cancelReservation(member2, book2);

        // Mixed scenario: borrow after reservation
        System.out.println("\n=== Alice borrows Brave New World (she reserved it first) ===");
        library.borrowBook(member1, book2);
        System.out.println("Alice's borrowed books: " + member1.getBorrowedBooks());
        library.displayReservedBooks(member1);

        // Final state
        System.out.println("\n=== Final State ===");
        System.out.println("Books in library: " + library.getBooks());
        System.out.println("Alice's borrowed books: " + member1.getBorrowedBooks());
        System.out.println("Bob's borrowed books: " + member2.getBorrowedBooks());
        System.out.println("Alice's reserved books: " + member1.getReservedBooks());
        System.out.println("Bob's reserved books: " + member2.getReservedBooks());
    }
}