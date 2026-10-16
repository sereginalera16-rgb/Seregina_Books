import ru.gr05504.application.BookService;
import ru.gr05504.domain.BookRepository;
import ru.gr05504.infrastructure.InMemoryBookRepository;
import ru.gr05504.ui.*;

public class MainConsole {
    public static void main(String[] args) {
        BookRepository repository = new InMemoryBookRepository();
        BookService service = new BookService(repository);
        BookController controller = new BookController(service);
        var cnsl = new Console(controller);
        controller.attachView(cnsl);
        controller.viewOpened();
    }
}
