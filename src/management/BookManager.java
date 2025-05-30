package management;

import datastructures.maps.CustomHashMap;
import library.Book;
import library.Member;

public class BookManager {
    // TODO: Define a data structure that stores ISBNs and their matching Book objects
    private CustomHashMap<String, Book> books;
    private MemberManager memberManager;

    public BookManager(MemberManager memberManager) {
        // TODO: Initialize your data structure here
        this.memberManager = memberManager;
        this.books = new CustomHashMap<>();
    }

    public void addBook(Book book) {
        if (book == null) {
            return;
        }
        books.put(book.getIsbn(), book);
    }

    public Book getBookByIsbn(String isbn) {
        return books.get(isbn);
    }

    public boolean isBookAvailable(String isbn) {
        return books.containsKey(isbn);
    }

    public void setBookAvailability(String isbn, boolean available) {
        Book book = getBookByIsbn(isbn);
        if (book != null) {
            book.setAvailable(available);
        }else {
            System.out.println("Book is null");
            return;
        }
    }

    public void addToWaitlist(String isbn, String memberId) {
        Book book = getBookByIsbn(isbn);
        if (book != null) {
            Member member = memberManager.getMember(memberId);
            if (member != null) {
                book.addToWaitlist(member);
            }else {
                System.out.println("Member is null");
                return;
            }
        }else {
            System.out.println("Book is null");
            return;
        }
    }

    public Member getNextFromWaitlist(String isbn) {
        Book book = getBookByIsbn(isbn);
        if (book != null) {
            return book.getNextInWaitlist();
        }
        return null;
    }

    public boolean hasWaitlist(String isbn) {
        Book book = getBookByIsbn(isbn);
        if (book != null) {
            return book.hasWaitlist();
        }
        return false;
    }
}