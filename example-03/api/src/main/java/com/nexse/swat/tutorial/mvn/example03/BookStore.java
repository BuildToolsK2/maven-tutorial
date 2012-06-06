package com.nexse.swat.tutorial.mvn.example03;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Set;

@Path("/bookstore")
public interface BookStore {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Set<Book> getBooks();

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Book getBook(@PathParam("id") long id);

}
