package com.leevilaune.association;

import java.util.ArrayList;
import java.util.Optional;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library(){
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book){
        this.books.add(book);
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void displayBooks(){
        int i = 1;
        for(Book b : this.books){
            System.out.println(i + ". " + b);
            i++;
        }
    }
    public void findBooksByAuthor(String author){
        System.out.println("Books by Author \""+author+"\"");
        for (Book b : this.books){
            if(b.getAuthor().equalsIgnoreCase(author)){
                System.out.println("Title: " + b.getTitle() + ", Year: " + b.getPublicationYear());
            }
        }
    }
    public void borrowBook(String user, String title){
        Optional<User> optUser = this.users.stream().filter(u->u.getName().equalsIgnoreCase(user))
                .findFirst();
        if(optUser.isEmpty()){
            return;
        }
        User user1 = optUser.get();
        user1.getBorrowedBooks().add(this.books.stream().filter(b->b.getTitle().equalsIgnoreCase(title)).findFirst().get());
        this.books.removeIf(b -> b.getTitle().equalsIgnoreCase(title));
    }
    public void returnBook(String user, Book book){
        Optional<User> optUser = this.users.stream().filter(u->u.getName().equalsIgnoreCase(user))
                .findFirst();
        if(optUser.isEmpty()){
            return;
        }
        User user1 = optUser.get();
        if(user1.getBorrowedBooks().contains(book)){
            user1.getBorrowedBooks().remove(book);
            this.addBook(book);
        }
    }
    public boolean isBookAvailable(String title){
        return this.books.stream().anyMatch(b->b.getTitle().equalsIgnoreCase(title));
    }

    public double getAverageBookRating(){
        double totalRating = 0;
        for(Book b : this.books){
            totalRating+=b.averageRating();
        }
        return totalRating/this.books.size();
    }

    public Book getMostReviewedBook(){
        Book mostReviewed = this.books.getFirst();
        for(Book b : this.books){
            if(b.getReviews().size() > mostReviewed.getReviews().size()) {
                mostReviewed = b;
            }
        }
        return mostReviewed;
    }
}
