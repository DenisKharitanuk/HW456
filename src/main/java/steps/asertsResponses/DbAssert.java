package steps.asertsResponses;

import entity.Book;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DbAssert {

    public static void sizeVerification(int size, List<Book> listOfBooks) {
        assertEquals(size, listOfBooks.size());
    }
}
