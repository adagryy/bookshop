package models;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Adam on 28.11.2015.
 */
@Entity
@Table(name = "books", schema = "bookstore")
public class BooksEntity {
    private int id;
    private String title;
    private String author;
    private BigDecimal price;
    private int wydawnictwo_id;
    private int kategoria;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "wydawnictwo_id")
    public int getWydawnictwo_id(){return wydawnictwo_id;}
    public void setWydawnictwo_id(int wydawnictwo_id){
        this.wydawnictwo_id = wydawnictwo_id;
    }

    @Basic
    @Column(name = "kategoria")
    public int getKategoria(){return kategoria;}
    public void setKategoria(int kategoria){
        this.kategoria = kategoria;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BooksEntity that = (BooksEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
