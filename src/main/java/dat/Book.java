package dat;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor

public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private int publicationYear;
    private double rating;
    private int pages;


    public Book(String title, String author, int publicationYear, double rating, int pages) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.rating = rating;
        this.pages = pages;
    }

@Override
public int compareTo(Book other) {
    return (int) (this.getRating() - other.getRating());

}
}