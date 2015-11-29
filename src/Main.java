import models.BooksEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;

/**
 * Created by ekot on 21.11.15.
 */
public class Main {
    public static void main(final String[] args) throws Exception {
        Main m = new Main();

        BooksEntity be = new BooksEntity();

        int record = 8;//numer rekordu w tabeli do wpisywania lub updateowania

        be.setId(record);
        be.setTitle("The lord of the Rings");
        be.setAuthor("Jakis tam");
        be.setPrice(new BigDecimal(9.99));
        be.setKategoria(2);
        be.setWydawnictwo_id(3);

        m.addRecord(be);

        //m.updateRecord(be);

        //m.deleteRecord(record);
    }

    public void addRecord(BooksEntity be) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(be);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
            //System.out.println("Error");
        } finally {
            session.flush();
            session.close();
        }
    }

    public void deleteRecord(int record_id) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            BooksEntity be = (BooksEntity) session.load(BooksEntity.class, new Integer(record_id));
            session.delete(be);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public void updateRecord(BooksEntity be) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(be);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
}
