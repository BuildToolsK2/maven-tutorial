package com.nexse.swat.tutorial.mvn.example03.srv;

import com.nexse.swat.tutorial.mvn.example03.Book;
import com.nexse.swat.tutorial.mvn.example03.BookStore;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InMemoryBookStore implements BookStore {

    private final Log log = LogFactory.getLog(getClass());

    private Map<Long, Book> bookMap = Collections.emptyMap();

    public void setBookMap(Map<Long, Book> bookMap) {
        this.bookMap = bookMap;
    }

    @Override
    public Set<Book> getBooks() {
        log.debug("getBooks(): no input params");
        HashSet<Book> books = new HashSet<Book>(bookMap.values());
        log.debug("getBooks(): returning; books=" + books);
        return books;
    }

    @Override
    public Book getBook(long id) {
        log.debug("getBook(): id=" + id);
        final Book book = bookMap.get(id);

        if (book == null) {
            log.debug("getBook(): book not found; id=" + id);
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        log.debug("getBook(): id=" + id + ", book=" + book);
        return book;
    }

}
