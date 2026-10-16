import ru.gr05504.ui.*;

public class Main {

    public static void main(String[] args) {
        BookRep repository = new InMemoryBookRep();
        BookService service = new BookService(repository);
        BookController controller = new BookController(service);
        var wnd = new Window(controller);
        controller.attachView(wnd);
        wnd.setVisible(true);
        controller.viewOpened();
    }
}
