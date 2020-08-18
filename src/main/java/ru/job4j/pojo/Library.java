package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean Code", 235);
        Book book2 = new Book("Java1", 334);
        Book book3 = new Book("History", 1234);
        Book book4 = new Book("Art of art", 432);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + ", pages: " + book.getPages());
        }
        Book tmp = books[3];
        books[3] = books[0];
        books[0] = tmp;
        System.out.println(System.lineSeparator() + "REPLACE BOOKS");
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + ", pages: " + book.getPages());
        }
        System.out.println(System.lineSeparator() + "CLEAN CODE BOOKS");
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if (book.getName().equals("Clean Code")) {
                System.out.println(book.getName() + ", pages: " + book.getPages());
            }
        }
    }
}
