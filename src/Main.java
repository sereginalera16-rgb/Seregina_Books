import ru.gr05504.application.BookService;
import ru.gr05504.domain.BookRepository;
import ru.gr05504.infrastructure.InMemoryBookRepository;
import ru.gr05504.ui.*;

public class Main {

    public static void main(String[] args) {
        BookRepository repository = new InMemoryBookRepository();
        BookService service = new BookService(repository);
        BookController controller = new BookController(service);
        var wnd = new Window(controller);
        controller.attachView(wnd);
        wnd.setVisible(true);
        controller.viewOpened();
    }
}
