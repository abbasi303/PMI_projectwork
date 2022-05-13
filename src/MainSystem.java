import java.io.*;
import java.util.Scanner;

public class MainSystem {
    static String fileName = null;
    static Library lib = new Library();
    static Scanner in = new Scanner(System.in);
    static  Boolean running = true;

    public static void main(String[] args){
        while(running){
            System.out.println(
                    """

                            Enter 0 for load a library.
                            Enter 1 for save and quit
                            Enter 2 for list all books in library
                            Enter 3 for add book to library""");
            int answer = in.nextInt();
            switch (answer) {
                case 0 -> {
                    System.out.println("Enter the file name to load");
                    loadScript(fileName);
                }
                case 1 -> saveAndQuit();
                case 2 -> System.out.println(lib.toString());
                case 3 -> addA_Book();
            }
        }
        System.exit(0);
    }

    private static void addA_Book() {
         int isbn;
         String title,author;
         double price;

         System.out.println("\n Enter Title:");
         title = in.next();

         System.out.println("\n Enter Author:");
         author = in.next();

         System.out.println("\n Enter ISBN:");
         isbn = Integer.parseInt(in.next());

         System.out.println("\n Enter Price:");
         price = Double.parseDouble(in.next());

         Book b = new Book(isbn, title,author,price);
         lib.addBook(b);
    }

    private static void saveAndQuit() {
        System.out.println("Enter file name: ");
        fileName = in.next() + ".ser";
        running = false;
        FileOutputStream fos;
        ObjectOutputStream out;
        try {
            fos = new FileOutputStream(fileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(lib);
            fos.close();
            out.close();

        } catch (IOException e) {
        //TODO Auto-generated catch block
        e.printStackTrace();
        }// TODO Auto-generated catch block


    }

    private static void loadScript(String name) {
        FileInputStream fis;
        ObjectInputStream in;
        File file = new File(name + ".ser");
        if (file.exists()) {
            try {
                fis = new FileInputStream(file);
                in = new ObjectInputStream(fis);
                lib = (Library) in.readObject();
                fis.close();
                in.close();

            } catch (IOException | ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } //TODO Auto-generated catch block

        } else {
            System.out.println("\nThe file does not exist!");
        }
    }
}
