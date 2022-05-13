import java.io.Serializable;


public record Book(int isbn, String title, String author, double price) implements Serializable { //setting class as public record  with neccessary parameters.

    // this is used to direct the isbn to the private int isbn

    @Override  //extracts a warning from the compiler if the annotated method doesn't actually override anything
    public String toString() {
        return "\nTitle:" + title + "\nAuthor:" + author +
                "\nISBN:" + isbn + "\nPrice:" + price + "\n";
    }

}
