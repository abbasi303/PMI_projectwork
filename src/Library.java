import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Library implements Serializable {
    private final List<Book> collection;

    public Library(){
        collection = new ArrayList<>();

    }
    public void addBook(Book book){
        collection.add(book);
    }
    @Override
    public String toString() {
        StringBuilder total = new StringBuilder("\n");

        for (Book b : collection) {     //using advanced for loop
            total = new StringBuilder(total + b.toString());

        }

        for (Book b : collection) {
            total.append(b.toString());
        }
        return total.toString();
    }
}
