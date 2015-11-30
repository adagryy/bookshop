import models.BooksEntity;
import models.BooksEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import java.util.Set;
import java.math.BigDecimal;
import java.math.BigDecimal;
import org.junit.Test;
import org.junit.*;

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
        BooksEntity book = createBook();
        Integer id = m.addRecord(book);

        // get
        BooksEntity bookFromDb = m.get(id);
        validate(book, bookFromDb);
    }


    protected BooksEntity createBook(){
        BooksEntity be = new BooksEntity();
        be.setId(15);
        be.setTitle("The lord of the Rings");
        be.setAuthor("Jakis tam");
        be.setPrice(new BigDecimal(9.99));
        be.setKategoria(2);
        be.setWydawnictwo_id(3);
        return be;
    }

    private void validate(BooksEntity expected, BooksEntity actual){
        assertEquals(expected.getAuthor(), actual.getAuthor());
        assertEquals(expected.getKategoria(), actual.getKategoria());
    }



    @org.junit.Test
    public void testDeleteRecord() throws Exception {

    }

    @org.junit.Test
    public void testUpdateRecord() throws Exception {

    }
}