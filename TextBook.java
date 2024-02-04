public class TextBook extends TeachingMaterial {
    private String title;
    private String author;

    private String publisher;

    private int publishedYear;

    public TextBook(){}

    public TextBook(String name, boolean onShoppingList, boolean required, boolean provided, String notes, String title, String author, String publisher, int publishedYear) {
        super(name, onShoppingList, required, provided, notes);
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishedYear = publishedYear;
    }

    public TextBook(String title, String author, String publisher, int publishedYear) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishedYear = publishedYear;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        return "TextBook{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishedYear=" + publishedYear +
                '}';
    }
}
