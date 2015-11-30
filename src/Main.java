import com.sun.prism.impl.Disposer;
import models.BooksEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;

/**
 * Created by ekot on 21.11.15.
 */
public class Main {
    public static void main(final String[] args) throws Exception {
        Main m = new Main();
        BooksEntity be = new BooksEntity();

        int record = 15;//numer rekordu w tabeli do wpisywania lub updateowania

        be.setId(record);
        be.setTitle("The lord of the Rings");
        be.setAuthor("Jakis tam");
        be.setPrice(new BigDecimal(9.99));
        be.setKategoria(2);
        be.setWydawnictwo_id(3);
        m.get(8);
        //m.addRecord(be);
        //m.updateRecord(be);

        //m.deleteRecord(record);
//        System.out.println(m.getRecordById(5));
//        for (BooksEntity iter : m.getAllRecords()) {
//            System.out.println(iter);
//        }
    }

//    public List<BooksEntity> getAllRecords(){
//        List<BooksEntity> books = new ArrayList<BooksEntity>();
//        Transaction trns = null;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            trns = session.beginTransaction();
//            books = session.createQuery("from books").list();
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//        } finally {
//            session.flush();
//            session.close();
//        }
//        return books;
//    }

//    public BooksEntity getRecordById(int record_id){
//        BooksEntity book = null;
//        Transaction trns = null;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            trns = session.beginTransaction();
//            String queryString = "from books where id = :id";
//            Query query = session.createQuery(queryString);
//            query.setInteger("id", record_id);
//            book = (BooksEntity) query.uniqueResult();
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//        } finally {
//            session.flush();
//            session.close();
//        }
//        return book;
//    }

    public Integer addRecord(BooksEntity be) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Integer id = null;
        try {
            trns = session.beginTransaction();
            id = (Integer) session.save(be);
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
        return id;
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
    public BooksEntity get(Integer id) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        BooksEntity returned = null;
        try {
            trns = session.beginTransaction();
            returned = (BooksEntity) session.get(BooksEntity.class, id);
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
        System.out.println(returned.getAuthor());
        System.out.println(returned.getKategoria());
        System.out.println(returned.getTitle());
        return returned;
    }
}
