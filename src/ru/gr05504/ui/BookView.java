package ru.gr05504.ui;

import ru.gr05504.BookFormState;
import ru.gr05504.domain.Book;

import java.util.List;

public interface BookView {
    String getAuthor();
    String getBookTitle();
    String getYear();
    String getInfo();

    void clearForm();
    void showBooks(List<Book> books);
    void render(BookFormState state);
}
