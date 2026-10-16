package ru.gr05504.domain;

public record Book(
        String author,
        String title,
        int year,
        String info
) {
    public Book {
        if (author == null || author.isBlank())
            throw new IllegalArgumentException("Поле автора не может быть пустым");
        if (title == null || title.isBlank())
            throw new IllegalArgumentException("Поле названия не может быть пустым");
        author = author.trim();
        title = title.trim();
        info = info == null ? "" : info.trim();
    }
}
