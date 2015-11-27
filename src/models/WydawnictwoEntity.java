package models;

import javax.persistence.*;

/**
 * Created by Adam on 27.11.2015.
 */
@Entity
@Table(name = "wydawnictwo", schema = "bookstore", catalog = "")
public class WydawnictwoEntity {
    private int idWyd;
    private String wydawnictwo;

    @Id
    @Column(name = "id_wyd")
    public int getIdWyd() {
        return idWyd;
    }

    public void setIdWyd(int idWyd) {
        this.idWyd = idWyd;
    }

    @Basic
    @Column(name = "wydawnictwo")
    public String getWydawnictwo() {
        return wydawnictwo;
    }

    public void setWydawnictwo(String wydawnictwo) {
        this.wydawnictwo = wydawnictwo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WydawnictwoEntity that = (WydawnictwoEntity) o;

        if (idWyd != that.idWyd) return false;
        if (wydawnictwo != null ? !wydawnictwo.equals(that.wydawnictwo) : that.wydawnictwo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idWyd;
        result = 31 * result + (wydawnictwo != null ? wydawnictwo.hashCode() : 0);
        return result;
    }
}
