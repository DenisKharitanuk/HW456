package repository;

import entity.Author;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.util.List;

import static configuration.LibraryDatabaseConfiguration.getSession;

public class AuthorRepository {
    Session session;

    public AuthorRepository(){
        session = getSession();
    }

    public List<Author> findAuthorById(long id) {
        final String hql = """
                SELECT * FROM author where id = :id
                """;

        NativeQuery<Author> query = session.createNativeQuery(hql, Author.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    public List<Author> findAuthorByName(String first_name) {
        final String hql = """
                SELECT * FROM author where first_name = :first_name
                """;

        NativeQuery<Author> query = session.createNativeQuery(hql, Author.class);
        query.setParameter("first_name", first_name);
        return query.getResultList();
    }
}
