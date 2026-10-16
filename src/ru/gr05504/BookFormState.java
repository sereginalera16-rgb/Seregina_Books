package ru.gr05504;

public record BookFormState(
        boolean addEnabled,
        String status,
        String error
) {
    public static BookFormState init(){
        return new BookFormState(false, "Заполните форму", null);
    }

    public static BookFormState setReady(){
        return new BookFormState(true, "Книгу можно добавить", null);
    }

    public static BookFormState setAdded(int booksCount){
        return new BookFormState(false, "Книга добавлена. Всего книг: " + booksCount, null);
    }

    public static BookFormState setError(String message){
        return new BookFormState(false, "Ошибка", message);
    }
}
