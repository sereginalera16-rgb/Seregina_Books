package ru.gr05504.application;

import ru.gr05504.domain.Book;
import ru.gr05504.domain.BookRepository;

import java.time.LocalDate;
import java.util.List;

public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository){
        this.repository = repository;
    }

    public void addBook(String author, String title, String yearText, String info){
        int year = parseYear(yearText);
        var book = new Book(author, title, year, info);
        repository.save(book);
    }

    public List<Book> getAllBooks(){
        return repository.findAll();
    }

    private int parseYear(String yearText){
        if (yearText == null || yearText.isBlank())
            throw new IllegalArgumentException("Поле год издания не может быть пустым");

        int year;
        try {
            year = Integer.parseInt(yearText.trim());
        } catch (NumberFormatException ex){
            throw new IllegalArgumentException("Год издания должен быть числом", ex);
        }
        if (year < 1000 || year > LocalDate.now().getYear())
            throw new IllegalArgumentException("Некорректный год");
        return year;
    }
}
