package Ex08;

import java.util.Objects;

public class Book {
    private String id;
    private String title;
    private String author;
    private int year;

    // Constructor
    public Book(String id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Getter
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    // Setter
    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Hai sách được xem là trùng nhau nếu cùng ID
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Book)) {
            return false;
        }

        Book book = (Book) o;

        return Objects.equals(id, book.id);
    }

    // HashCode dựa trên ID
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // In thông tin sách
    @Override
    public String toString() {
        return "ID: " + id
                + " | Tên sách: " + title
                + " | Tác giả: " + author
                + " | Năm: " + year;
    }
}
