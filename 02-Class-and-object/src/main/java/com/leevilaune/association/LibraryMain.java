package com.leevilaune.association;

public class LibraryMain {

    public static void main(String[] args) {
        Library library = new Library();
        User u1 = new User(69,"Nasse Seta");
        library.addUser(u1);
        // Add books
        Book b1 = new Book("George Orwell", "1984", 1949);
        Book b2 = new Book("J.R.R. Tolkien", "The Lord of the Rings", 1954);
        Book b3 = new Book("Harper Lee", "To Kill a Mockingbird", 1960);

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        System.out.println("Initial library:");
        for (Book b : library.getBooks()) System.out.println(b);

        // Task 2: Borrow and return
        library.borrowBook("Nasse Seta","1984");
        System.out.println("Is '1984' available? " + library.isBookAvailable("1984"));
        System.out.println(u1);
        library.returnBook("Nasse Seta",b1);
        System.out.println("Is '1984' available after return? " + library.isBookAvailable("1984"));

        // Task 4: Ratings & Reviews
        b1.setRating(4.5);
        b1.addReview("A chilling dystopia!");
        b1.addReview("Still relevant today.");

        b2.setRating(5.0);
        b2.addReview("An epic masterpiece.");

        b3.setRating(4.0);

        // Task 5: Statistics
        System.out.println("\nAverage rating in library: " + library.getAverageBookRating());
        System.out.println("Most reviewed book: " + library.getMostReviewedBook());

        System.out.println("\nFinal library state:");
        for (Book b : library.getBooks()) System.out.println(b);

        System.out.println(u1);
    }
}
