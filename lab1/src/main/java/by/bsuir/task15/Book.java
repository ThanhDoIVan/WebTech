package by.bsuir.task15;

import java.util.Objects;

public class Book implements Cloneable, Comparable {
    private String title;
    private String author;
    private int price;
    private int isbn;
    private static int edition;

    public Book(
            String title,
            String author,
            int isbn,
            int price
    ) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return price == book.price && isbn == book.isbn && title.equals(book.title) && author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, price, isbn);
    }

    @Override
    public String toString() {
        return title + " by " + author + "\n" +
                "ISBN number: " + isbn + "\n" +
                "Price: " + price + "\n" +
                "Edition " + edition;
    }

    @Override
    public Book clone() {
        try {
            Book clone = (Book) super.clone();
            clone.title = title;
            clone.author = author;
            clone.isbn = isbn;
            clone.price = price;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public int compareTo(Object o) {
        Book compareTo = (Book) o;
        return Integer.compare(isbn, compareTo.isbn);
    }
}
