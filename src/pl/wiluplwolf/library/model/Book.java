package pl.wiluplwolf.library.model;

public class Book {
    private long id;
    private String title;
    private String author;
    private boolean isAvailable;

    Book() {
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=\"" + id +
                "\" title=\"" + title +
                "\" author=\"" + author +
                "\" available=\"" + isAvailable +
                "\"}";
    }
}
