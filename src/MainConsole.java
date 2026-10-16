import ru.gr05504.ui.*;

public class MainConsole {
    public static void main(String[] args) {
        BookRep repository = new InMemoryBookRep();
        BookService service = new BookService(repository);
        BookController controller = new BookController(service);
        var cnsl = new Console(controller);
        controller.attachView(cnsl);
        controller.viewOpened();
    }
}
