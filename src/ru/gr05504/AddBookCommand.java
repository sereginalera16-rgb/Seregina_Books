package ru.gr05504;

import ru.gr05504.ui.BookController;

public class AddBookCommand implements Command {
    private final BookController controller;

    public AddBookCommand(BookController controller){
        this.controller = controller;
    }

    @Override
    public void execute() {
        if (canExecute()) {
            controller.addBookClicked();
        }
    }

    @Override
    public boolean canExecute() {
        return controller.isAddAllowed();
    }
}
