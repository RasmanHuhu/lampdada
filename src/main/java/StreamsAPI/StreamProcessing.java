package StreamsAPI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamProcessing {
    // Create a list of books

    public static void main(String[] args) {


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
        books.add(new Book("Nineteen Eighty-Four", "George Orwell", 1949, 8, 328));
        books.add(new Book("Animal Farm", "George Orwell", 1945, 7, 112));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 6, 180));
        books.add(new Book("Pride and Prejudice", "Jane Austen", 1813, 9, 226));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960, 2, 281));
        books.add(new Book("The Catcher in the Rye", "J.D. Salinger", 1951, 1, 234));
        books.add(new Book("The Little Prince", "Antoine de Saint-Exupéry", 1943, 10, 96));
        books.add(new Book("The Picture of Dorian Gray", "Oscar Wilde", 1890, 7, 254));
        books.add(new Book("The Book Thief", "Markus Zusak", 2005, 8, 552));
        books.add(new Book("The Kite Runner", "Khaled Hosseini", 2003, 9, 371));
        books.add(new Book("The Da Vinci Code", "Dan Brown", 2003, 5, 689));
        books.add(new Book("The Alchemist", "Paulo Coelho", 1988, 6, 197));
        books.add(new Book("The Name of the Rose", "Umberto Eco", 1980, 7, 536));
        books.add(new Book("The Shadow of the Wind", "Carlos Ruiz Zafón", 2001, 8, 487));
        books.add(new Book("The Curious Incident of the Dog in the Night-Time", "Mark Haddon", 2003, 9, 226));
        books.add(new Book("The Fault in Our Stars", "John Green", 2012, 10, 313));
        


        // Calculate the average rating of all books
        double avgRating = books.stream()
                .mapToDouble(x -> x.getRating())
                .average()
                .getAsDouble();

        System.out.println("Average rating: " + avgRating);
        System.out.println("----------------");


//        Filter and display books published after a specific year.

        books.stream()
                .filter(book -> book.getPublicationYear() > 1998)
                .forEach(System.out::println);
        System.out.println("----------------");

//        Sort books by rating in descending order.

            books.stream()
                    .sorted(Comparator.comparing(Book::getRating).reversed())
                    .forEach(System.out::println);
        System.out.println("----------------");

//        Find and display the title of the book with the highest rating.

            books.stream()
                    .sorted(Comparator.comparing(Book::getRating).reversed())
                    .limit(1)
                    .forEach(System.out::println);
            System.out.println("----------------");

//        Group books by author and calculate the average rating for each author's books.
        books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.averagingDouble(Book::getRating)))
                .forEach((author, avg) -> System.out.println(author + " - " + avg));
        System.out.println("----------------");

//        Calculate the total number of pages for all books (assuming each book has a fixed number of pages).

            int totalNumberOfPages = books.stream()
                    .mapToInt(Book::getPages)
                    .sum();
            System.out.println("Total number of pages: " + totalNumberOfPages);
            System.out.println("----------------");
    }
}
