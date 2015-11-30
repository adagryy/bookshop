import models.BooksEntity;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by ekot on 29.11.15.
 */
public class MainTest {

    private Main m = new Main();

    @org.junit.Test
    public void testMain() throws Exception {
    }

    @org.junit.Test
    public void testAddRecord() throws Exception {
        BooksEntity book = createBook();
        Integer id = m.addRecord(book);

        // get
        BooksEntity bookFromDb = m.get(id);
        validate(book, bookFromDb);
    }

    @org.junit.Test
    public void testDeleteRecord() throws Exception {
        BooksEntity book = createBook();
        Integer id = m.addRecord(book);

        // get
        BooksEntity bookFromDb = m.get(id);
        validate(book, bookFromDb);

        // delete
        m.deleteRecord(19);

        // assert
//        BooksEntity bookPrevious = m.get(id);
//        assertNotEquals(bookFromDb.getAuthor(), bookPrevious.getAuthor());
//        assertNotEquals(bookFromDb.getKategoria(), bookPrevious.getKategoria());
    }

    @org.junit.Test
    public void testUpdateRecord() throws Exception {

    }
    protected BooksEntity createBook(){
        BooksEntity book = new BooksEntity();
        book.setId(19);
        book.setTitle("Finlandium lewiosa");
        book.setAuthor("Aleksander Kwasniewski");
        book.setPrice(new BigDecimal(9.99));
        book.setKategoria(2);
        book.setWydawnictwo_id(3);
        return book;
    }

    private void validate(BooksEntity expected, BooksEntity actual){
        assertEquals(expected.getAuthor(), actual.getAuthor());
        assertEquals(expected.getKategoria(), actual.getKategoria());
    }
}