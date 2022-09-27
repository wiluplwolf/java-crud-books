package pl.wiluplwolf.library.service;

import pl.wiluplwolf.library.model.Book;

import java.util.*;
import java.util.stream.Stream;

public class LibraryService implements Library<Book>{
    // list of books in library
    private Map<Long, Book> bookMap = new HashMap<>();
    private Random randomBookId = new Random();
    @Override
    public Book create(final Book createBook) {
        long uniqueId = randomBookId.nextLong(100_000);
        boolean validId = false;
        while (validId) {
            if(bookMap.containsKey(uniqueId)) {
                uniqueId = randomBookId.nextLong(100_000);
            } else {
                validId = true;
            }
        }
        createBook.setId(uniqueId);
        bookMap.put(uniqueId, createBook);
        System.out.println("---- Book has been added ---- "
                + createBook + "\n");
        return createBook;
    }

    @Override
    public Optional<Book> read(final long id) {
        return Optional.ofNullable(bookMap.get((int)id));
    }

    @Override
    public List<Book> readAll() {
        if (bookMap.size() == 0) System.out.println("---- Empty library ----\n");
        return new ArrayList<>(bookMap.values());
    }

    @Override
    public void update(final long id, final Book bookUpdate) {
        for (Book book : bookMap.values()) {
            if (book.getId() == id) {
                book.setAuthor(bookUpdate.getAuthor());
                book.setTitle(bookUpdate.getTitle());
                book.setAvailable(bookUpdate.isAvailable());
            }
        }
    }

    @Override
    public void delete(final long id) {
        if (bookMap.containsKey(id)) {
            bookMap.remove(id);
            System.out.println("---- Book removed");
        } else {
            System.out.println("---- Book with id " + id + " does not exist");
        }
    }
}
