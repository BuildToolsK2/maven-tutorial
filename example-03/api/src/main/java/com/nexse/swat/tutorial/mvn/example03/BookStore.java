package com.nexse.swat.tutorial.mvn.example03;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.Set;

@Path("/bookstore")
public interface BookStore {

    @GET
    @Produces("application/json")
    Set<Book> getBooks();

    @GET
    @Path("{id}")
    @Produces("application/json")
    Book getBook(@PathParam("id") long id);

}
