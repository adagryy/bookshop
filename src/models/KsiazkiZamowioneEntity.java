package models;

import javax.persistence.*;

/**
 * Created by Adam on 28.11.2015.
 */
@Entity
@Table(name = "ksiazki_zamowione", schema = "bookstore")
public class KsiazkiZamowioneEntity {
    private int idZ;
    private int liczbaKsiazek;

    @Id
    @Column(name = "id_z")
    public int getIdZ() {
        return idZ;
    }

    public void setIdZ(int idZ) {
        this.idZ = idZ;
    }

    @Basic
    @Column(name = "liczba_ksiazek")
    public int getLiczbaKsiazek() {
        return liczbaKsiazek;
    }

    public void setLiczbaKsiazek(int liczbaKsiazek) {
        this.liczbaKsiazek = liczbaKsiazek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KsiazkiZamowioneEntity that = (KsiazkiZamowioneEntity) o;

        if (idZ != that.idZ) return false;
        if (liczbaKsiazek != that.liczbaKsiazek) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idZ;
        result = 31 * result + liczbaKsiazek;
        return result;
    }
}
