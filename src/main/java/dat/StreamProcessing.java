package dat;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamProcessing {
        public static void main(String[] args) {
            // Create a list of books

            //Når vi laver en list om til et Stream, så betyder det at vi kan arbejde med elementerne, i dette tilfælde de books i listen


            List<Book> books = new ArrayList<>();

            books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, 5, 1178));
            books.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937, 6, 310));
            books.add(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997, 4, 223));
            books.add(new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", 1998, 4, 251));
            books.add(new Book("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", 1999, 4, 317));
            books.add(new Book("Harry Potter and the Goblet of Fire", "J.K. Rowling", 2000, 7, 636));
            books.add(new Book("Kafka on the Shore", "Haruki Murakami", 2002, 10, 505));
            books.add(new Book("The Wind-Up Bird Chronicle", "Haruki Murakami", 1994, 4, 607));
            books.add(new Book("1Q84", "Haruki Murakami", 2009, 3, 925));

            System.out.println("******** calc avg rating of all books");

            // Calculate the average rating of all books
            double avgRating = books.stream()
                    .mapToDouble(x -> x.getRating())
                    .average()
                    .getAsDouble();
            System.out.println("average: " + avgRating);

            System.out.println("***** filter + display books published after 1990 *****");

            // Filter and display books published after a specific year
            books.stream()
                    .filter(book -> book.getPublicationYear() > 1990)
                            .forEach(book -> System.out.println(book.getTitle()));
                    //Co-Pilot:.forEach(System.out::println);

            System.out.println("************ SORT ************");

            // Sort books by rating in descending order
            books.stream()
                    .sorted((book1, book2) -> (int) (book2.getRating() - book1.getRating()))
                    .forEach(System.out::println);

            System.out.println("************ HIGHEST RATED BOOK************");

            // Find and display the title of the highest-rated book
          books.stream() //Stream<Book>
                    .sorted((book1, book2) -> (int) (book2.getRating() - book1.getRating()))
                    .limit(1)
                    .forEach(book -> System.out.println(book.getTitle()));

            System.out.println("***** Alternativ fra Jon *****");
          //Alternativt fra Jon
            books.stream()
                    .max(Comparator.comparing(Book::getRating))
                            .ifPresent(book -> System.out.println(book.getTitle()));


            // Group books by author and calculate average rating for each author
            //Grupperer ud fra en function, og så en collector, som er en anden function
            books.stream()
                    .collect(Collectors.groupingBy(Book::getAuthor, Collectors.averagingDouble(Book::getRating)));


            System.out.println("*** number of pages for all books ***");

            // Calculate the total number of pages for all books
            books.stream()
                    .mapToInt(book -> book.getPages())
                    .sum();
            System.out.println("Total number of pages: " + books.stream()
                    .mapToInt(book -> book.getPages())
                    .sum());
        }
    }

