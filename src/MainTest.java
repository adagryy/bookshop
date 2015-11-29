import models.BooksEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.math.BigDecimal;

/**
 * Created by ekot on 29.11.15.
 */
public class MainTest {

    @org.junit.Test
    public void testMain() throws Exception {

    }

    @org.junit.Test
    public void testAddRecord() throws Exception {

        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        trns = session.beginTransaction();

        Main m = new Main();
        BooksEntity be = new BooksEntity();

        assertTrue(session.save(be) instanceof BooksEntity);

    }

    @org.junit.Test
    public void testDeleteRecord() throws Exception {

    }

    @org.junit.Test
    public void testUpdateRecord() throws Exception {

    }
}