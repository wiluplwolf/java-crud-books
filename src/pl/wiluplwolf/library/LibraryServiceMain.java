package pl.wiluplwolf.library;

import pl.wiluplwolf.library.model.Book;
import pl.wiluplwolf.library.service.LibraryService;

import java.util.List;

public class LibraryServiceMain {
    public static void main(String[] args) {
        System.out.println("########## Book library - CRUD ##########");

        // create CRUD object
        LibraryService libraryService = new LibraryService();

        System.out.println("* Library before adding any book:");
        for (Book book : libraryService.readAll()) {
            System.out.println(book);
        }

        System.out.println("* Adding new book.");
        Book hobbit = new Book("Hobbit", "J.R.R. Tolkien");
        System.out.println("** Uncreated/unsaved book has id = 0.");
        System.out.println(hobbit + "\n");
        System.out.println("** Created/saved book has unique id.");
        Book createdHobbit = libraryService.create(hobbit);
        //System.out.println(createdHobbit + "\n");

        System.out.println("** Library after adding first book: "
                + "\n" + libraryService.readAll() + "\n");

        System.out.println("* Adding next book.");
        Book harry = new Book("Harry Potter and the philosopher's DIAMOND", "J.K. Rowling");
        libraryService.create(harry);
        System.out.println("** Library after adding second book: "
                + "\n" + libraryService.readAll() + "\n");

        System.out.println("* Updating the title of an incorrectly entered book.");
        harry.setTitle("Harry Potter and the philosopher's stone");
        libraryService.update(harry.getId(), harry);
        System.out.println("** Library after updating: "
                + "\n" + libraryService.readAll() + "\n");

        System.out.println("* Removing book with highest id.");
        long highestId = 0;
        for (Book book : libraryService.readAll()) {
            if (book.getId() > highestId) highestId = book.getId();
        }
        libraryService.delete(highestId);

        System.out.println("** Library after removing book: "
                + "\n" + libraryService.readAll() + "\n");
    }
}
