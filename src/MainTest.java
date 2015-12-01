import models.BooksEntity;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

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
        BooksEntity book = createBook("Finlandium lewiosa", "Aleksander Kwasniewski" );
        Integer id = m.addRecord(book);

        // get
        BooksEntity bookFromDb = m.get(id);

        assertEquals(book.getAuthor(), bookFromDb.getAuthor());
        assertEquals(book.getKategoria(), bookFromDb.getKategoria());
        //validate(book, bookFromDb);
    }

    @org.junit.Test
    public void testDeleteRecord() throws Exception {
        BooksEntity book = createBook("Finlandium lewiosa", "Aleksander Kwasniewski");
        Integer id = m.addRecord(book);

        assertNotNull(book); //sprawdzammy, czy jest obiekt o identyfikatorze id NIE jest null
        // delete
        m.deleteRecord(id);

        // get
        BooksEntity bookFromDb = m.get(id);
        assertNull(bookFromDb);//po usunięciu powinno być null
    }

    @org.junit.Test
    public void testUpdateRecord() throws Exception {
        BooksEntity updatedBook = createBook("Die another day", "James Bond");

        int id = 2;

        BooksEntity book = m.get(id);//bierzemy "stary" wiersz
        updatedBook.setId(id);

        //updating
        m.updateRecord(updatedBook); //updatujemy

        assertNotEquals(book.getTitle(), updatedBook.getTitle());
        assertNotEquals(book.getAuthor(), updatedBook.getAuthor());
//        assertNotEquals(book.getPrice(), updatedBook.getPrice());
//        assertNotEquals(book.getWydawnictwo_id(), updatedBook.getWydawnictwo_id());
//        assertNotEquals(book.getKategoria(), updatedBook.getKategoria());

    }
    protected BooksEntity createBook(String title, String author){
        BooksEntity book = new BooksEntity();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPrice(new BigDecimal(9.99));
        book.setKategoria(2);
        book.setWydawnictwo_id(3);
        return book;
    }

//    private void validate(BooksEntity expected, BooksEntity actual){
//        assertEquals(expected.getAuthor(), actual.getAuthor());
//        assertEquals(expected.getKategoria(), actual.getKategoria());
//    }



}