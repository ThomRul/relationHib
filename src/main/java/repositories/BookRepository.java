package repositories;

import models.Book;
import repositories.base.CrudRepository;

public class BookRepository extends CrudRepository<Book, Long> {
    public BookRepository() {
        super(Book.class);
    }
}
