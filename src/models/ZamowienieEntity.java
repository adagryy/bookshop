package models;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Adam on 27.11.2015.
 */
@Entity
@Table(name = "zamowienie", schema = "bookstore", catalog = "")
public class ZamowienieEntity {
    private int idZamowienia;
    private String status;
    private Date data;

    @Id
    @Column(name = "id_zamowienia")
    public int getIdZamowienia() {
        return idZamowienia;
    }

    public void setIdZamowienia(int idZamowienia) {
        this.idZamowienia = idZamowienia;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "data")
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZamowienieEntity that = (ZamowienieEntity) o;

        if (idZamowienia != that.idZamowienia) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idZamowienia;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }
}
