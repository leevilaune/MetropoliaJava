package com.leevilaune.staticv.library.system;

import com.leevilaune.staticv.library.model.*;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<LibraryMember> members;

    public Library(){
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void addMember(LibraryMember member) {
        this.members.add(member);
    }

    public void borrowBook(LibraryMember member, Book book) {
        if(book.isReserved()){
            return;
        }
        this.members.stream()
                .filter(m->m.getMemberID()==member.getMemberID())
                .findFirst()
                .get()
                .getBorrowedBooks()
                .add(book);
        this.books.remove(book);
    }

    public void returnBook(LibraryMember member, Book book) {
        this.members.stream()
                .filter(m->m.getMemberID()==member.getMemberID())
                .findFirst()
                .get()
                .getBorrowedBooks()
                .remove(book);
        this.books.add(book);
    }

    public void reserveBook(LibraryMember member, Book book){
        if(book.isReserved()){
            return;
        }
        this.members.stream()
                .filter(m->m.getMemberID()==member.getMemberID())
                .findFirst()
                .get()
                .getReservedBooks()
                .add(book);
        book.setReserved(true);
    }

    public void cancelReservation(LibraryMember member, Book book){
        this.members.stream()
                .filter(m->m.getMemberID()==member.getMemberID())
                .findFirst()
                .get()
                .getReservedBooks()
                .remove(book);
        book.setReserved(false);
    }
    public void displayReservedBooks(LibraryMember member){
        System.out.println(member.getName() + " reservations:");
        member.getBorrowedBooks().forEach(System.out::println);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<LibraryMember> getMembers() {
        return members;
    }

    public void setMembers(List<LibraryMember> members) {
        this.members = members;
    }
}