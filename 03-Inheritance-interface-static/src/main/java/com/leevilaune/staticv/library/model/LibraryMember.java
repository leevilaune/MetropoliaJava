package com.leevilaune.staticv.library.model;

import java.util.ArrayList;
import java.util.List;

public class LibraryMember {

    private String name;
    private int memberID;
    private List<Book> borrowedBooks;
    private List<Book> reservedBooks;

    public LibraryMember(String name, int memberID) {
        this.name = name;
        this.memberID = memberID;
        this.borrowedBooks = new ArrayList<>();
        this.reservedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public List<Book> getReservedBooks() {
        return reservedBooks;
    }

    public void setReservedBooks(List<Book> reservedBooks) {
        this.reservedBooks = reservedBooks;
    }

    @Override
    public String toString() {
        return "LibraryMember{" +
                "name='" + name + '\'' +
                ", memberID='" + memberID + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}
