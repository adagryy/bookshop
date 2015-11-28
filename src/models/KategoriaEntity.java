package models;

import javax.persistence.*;

/**
 * Created by Adam on 28.11.2015.
 */
@Entity
@Table(name = "kategoria", schema = "bookstore")
public class KategoriaEntity {
    private int idKat;
    private String nazwaKat;

    @Id
    @Column(name = "id_kat")
    public int getIdKat() {
        return idKat;
    }

    public void setIdKat(int idKat) {
        this.idKat = idKat;
    }

    @Basic
    @Column(name = "nazwa_kat")
    public String getNazwaKat() {
        return nazwaKat;
    }

    public void setNazwaKat(String nazwaKat) {
        this.nazwaKat = nazwaKat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KategoriaEntity that = (KategoriaEntity) o;

        if (idKat != that.idKat) return false;
        if (nazwaKat != null ? !nazwaKat.equals(that.nazwaKat) : that.nazwaKat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idKat;
        result = 31 * result + (nazwaKat != null ? nazwaKat.hashCode() : 0);
        return result;
    }
}
