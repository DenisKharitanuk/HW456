package repository;

import entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;

import static configuration.LibraryDatabaseConfiguration.getSession;

public class BookRepository {
    Session session;

    public BookRepository() {
        session = getSession();
    }

    public List<Book> findAll() {
        final String hql = """
                SELECT * FROM Book
                """;

        return session.createNativeQuery(hql, Book.class)
                .getResultList();
    }

    public List<Book> findBookByTitle(String bookTitle) {
        final String hql = """
                SELECT * FROM book where book_title = :bookTitle
                """;

        NativeQuery<Book> query = session.createNativeQuery(hql, Book.class);
        query.setParameter("bookTitle", bookTitle);
        return query.getResultList();
    }

    public List<Book> findBookByAuthorId(long id) {
        final String hql = """
                SELECT * FROM book where author_id = :id
                """;

        NativeQuery<Book> query = session.createNativeQuery(hql, Book.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    public void deleteAll() {
        final String hql = "DELETE FROM book" ;

        Transaction tr = session.beginTransaction();
        session.createNativeQuery(hql, Book.class)
                .executeUpdate();
        tr.commit();
    }

    public void deleteBookByTitle(String bookTitle) {
        final String hql = """
                DELETE FROM book where book_title = :bookTitle
                """;

        Transaction tr = session.beginTransaction();
        NativeQuery<Book> query = session.createNativeQuery(hql, Book.class);
        query.setParameter("bookTitle", bookTitle).executeUpdate();
        tr.commit();
    }

    public void insertBook(String bookTitle, long authorId) {
        final String hql = """
                INSERT INTO book
                (book_title, author_id)
                VALUES(:bookTitle, :authorId)
                """;

        Transaction tr = session.beginTransaction();
        NativeQuery<Book> query = session.createNativeQuery(hql, Book.class);
        query.setParameter("bookTitle", bookTitle);
        query.setParameter("authorId", authorId);
        query.executeUpdate();
        tr.commit();
    }
}
