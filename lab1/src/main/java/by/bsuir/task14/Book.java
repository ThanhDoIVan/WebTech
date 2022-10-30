package by.bsuir.task14;

import java.util.Objects;

public class Book implements Cloneable {
    private String title;
    private String author;
    private int price;
    private static int edition;

    public Book(
            String title,
            String author,
            int price
    ) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return price == book.price && title.equals(book.title) && author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, price);
    }

    @Override
    public String toString() {
        return title + " by " + author + "\n" +
                "Price: " + price + "\n" +
                "Edition " + edition;
    }

    @Override
    public Book clone() {
        try {
            Book clone = (Book) super.clone();
            clone.title = title;
            clone.author = author;
            clone.price = price;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
