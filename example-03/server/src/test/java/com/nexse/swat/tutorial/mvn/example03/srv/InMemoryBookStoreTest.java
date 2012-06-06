package com.nexse.swat.tutorial.mvn.example03.srv;

import com.nexse.swat.tutorial.mvn.example03.Book;
import com.nexse.swat.tutorial.mvn.example03.BookStore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class InMemoryBookStoreTest {

    @Autowired
    private BookStore store;

    @Test
    public void testGetBooks() throws Exception {
        Set<Book> books = store.getBooks();
        assertNotNull("books", books);
        assertEquals("books.size==4", 4, books.size());
    }

    @Test
    public void testGetBook1() throws Exception {
        Book book1 = store.getBook(1);
        assertNotNull("book1", book1);
        assertEquals("book1.id", 1L, book1.getId());
        assertEquals("book1.author", "Douglas Adams", book1.getAuthor());
        assertEquals("book1.title", "The Hitchhiker's Guide to the Galaxy", book1.getTitle());
    }
}
