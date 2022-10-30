package by.bsuir.task16;

import by.bsuir.task16.comparator.AuthorComparator;
import by.bsuir.task16.comparator.PriceComparator;
import by.bsuir.task16.comparator.TitleComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>(){static {
            new Book("Oil!", "Upton Sinclair", 1500);
            new Book("Of Human Bondage", "William Somerset Maugham", 2000);
            new Book("The Firm", "John Grisham", 1200);
            new Book("How to make a million $ in a day", "Ilya Budevich", 1000000);
        }};

        Comparator<Book> titleComparator = new TitleComparator();

        Comparator<Book> titleThenAuthorComparator = titleComparator
                .thenComparing(new AuthorComparator());

        Comparator<Book> authorThenTitleComparator = new AuthorComparator()
                .thenComparing(titleComparator);

        Comparator<Book> authorTitlePriceComparator = new AuthorComparator()
                .thenComparing(titleComparator)
                .thenComparing(new PriceComparator());

        books.sort(titleComparator);
        books.sort(titleThenAuthorComparator);
        books.sort(authorThenTitleComparator);
        books.sort(authorTitlePriceComparator);
    }
}
