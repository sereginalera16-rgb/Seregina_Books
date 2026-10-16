package ru.gr05504;

public interface Command {
    void execute();
    boolean canExecute();
}
