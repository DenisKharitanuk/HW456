package db_tests;

import entity.Book;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.BookRepository;

import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static steps.asertsResponses.DbAssert.sizeVerification;

@Story("Data base test")
@Epic("Get tests")
public class DbTest {
    @DisplayName("Проверка базы данных")
    @Description("CRUD операции выполняются")
    @Test
    public void insertNewBookTest() {
        BookRepository bookRepository = new BookRepository();
        long authorId = 1;
        String book1 = randomAlphabetic(5);
        String book2 = randomAlphabetic(3);

        bookRepository.deleteAll();

        bookRepository.insertBook(book2, authorId);
        bookRepository.insertBook(book1, authorId);

        List<Book> listOfBooks = bookRepository.findAll();
        sizeVerification(2, listOfBooks);
        System.out.println("Cозданные книги: " + listOfBooks);

        List<Book> sanctuaryBook = bookRepository.findBookByTitle(book1);
        sizeVerification(1, sanctuaryBook);
        System.out.println("Найденная книга по названию " + book1 + " : " + sanctuaryBook);

        bookRepository.deleteBookByTitle(book1);
        List<Book> cemeteryBook = bookRepository.findAll();
        sizeVerification(1, cemeteryBook);
        System.out.println("Найденная книга по названию " + book2 + " после удаления другой книги: " + cemeteryBook);
    }
}
