package ru.gr05504.ui;

import ru.gr05504.BookFormState;
import ru.gr05504.application.BookService;

public class BookController {
    private final BookService service;
    private BookView view;

    public BookController(BookService service) {
        this.service = service;
    }

    public void attachView(BookView view) {
        this.view = view;
    }

    public void addBookClicked(){
        try {
            service.addBook(
                    view.getAuthor(),
                    view.getBookTitle(),
                    view.getYear(),
                    view.getInfo()
            );
            var books = service.getAllBooks();
            view.showBooks(books);
            view.clearForm();
            view.render(BookFormState.setAdded(books.size()));
        } catch (IllegalArgumentException ex) {
            view.render(BookFormState.setError(ex.getMessage()));
        }
    }

    public void viewOpened(){
        view.showBooks(service.getAllBooks());
        view.render(BookFormState.init());
    }

    public void inputChanged(){
        if (isAddAllowed()){
            view.render(BookFormState.setReady());
        } else {
            view.render(BookFormState.init());
        }
    }

    public boolean isAddAllowed(){
        return isNotBlank(view.getAuthor())
                && isNotBlank(view.getBookTitle())
                && isNotBlank(view.getYear());
    }

    private boolean isNotBlank(String value) {
        return value != null && !value.isBlank();
    }
}
