package com.ja.xmlgeneratorspring.entity;
// Generated 2017-04-16 17:46:31 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Mecze generated by hbm2java
 */
@Entity
@Table(name = "mecze")
public class Mecz implements java.io.Serializable {

    @Id
    @GeneratedValue
    private int idMecz;
    private String przeciwnik;
    private Integer bramkiStrzelone;
    private Integer bramkiStracone;
    private Integer strzalyWlasne;
    private Integer strzalyPrzeciwnika;
    private Integer posiadanieWlasne;
    private Integer posiadaniePrzeciwnika;
    private Integer zolteWlasne;
    private Integer zoltePrzeciwnika;
    private Integer czerwoneWlasne;
    private Integer czerwonePrzeciwnika;
    private Date data;
    private BigDecimal przebiegnietyDystans;
    private Integer iloscKibicow;

    public Mecz() {
    }

    public Mecz(int idMecz) {
        this.idMecz = idMecz;
    }

    public Mecz(int idMecz, String przeciwnik, Integer bramkiStrzelone, Integer bramkiStracone, Integer strzalyWlasne, Integer strzalyPrzeciwnika, Integer posiadanieWlasne, Integer posiadaniePrzeciwnika, Integer zolteWlasne, Integer zoltePrzeciwnika, Integer czerwoneWlasne, Integer czerwonePrzeciwnika, Date data, BigDecimal przebiegnietyDystans, Integer iloscKibicow) {
        this.idMecz = idMecz;
        this.przeciwnik = przeciwnik;
        this.bramkiStrzelone = bramkiStrzelone;
        this.bramkiStracone = bramkiStracone;
        this.strzalyWlasne = strzalyWlasne;
        this.strzalyPrzeciwnika = strzalyPrzeciwnika;
        this.posiadanieWlasne = posiadanieWlasne;
        this.posiadaniePrzeciwnika = posiadaniePrzeciwnika;
        this.zolteWlasne = zolteWlasne;
        this.zoltePrzeciwnika = zoltePrzeciwnika;
        this.czerwoneWlasne = czerwoneWlasne;
        this.czerwonePrzeciwnika = czerwonePrzeciwnika;
        this.data = data;
        this.przebiegnietyDystans = przebiegnietyDystans;
        this.iloscKibicow = iloscKibicow;
    }

    public int getIdMecz() {
        return this.idMecz;
    }

    public void setIdMecz(int idMecz) {
        this.idMecz = idMecz;
    }

    public String getPrzeciwnik() {
        return this.przeciwnik;
    }

    public void setPrzeciwnik(String przeciwnik) {
        this.przeciwnik = przeciwnik;
    }

    public Integer getBramkiStrzelone() {
        return this.bramkiStrzelone;
    }

    public void setBramkiStrzelone(Integer bramkiStrzelone) {
        this.bramkiStrzelone = bramkiStrzelone;
    }

    public Integer getBramkiStracone() {
        return this.bramkiStracone;
    }

    public void setBramkiStracone(Integer bramkiStracone) {
        this.bramkiStracone = bramkiStracone;
    }

    public Integer getStrzalyWlasne() {
        return this.strzalyWlasne;
    }

    public void setStrzalyWlasne(Integer strzalyWlasne) {
        this.strzalyWlasne = strzalyWlasne;
    }

    public Integer getStrzalyPrzeciwnika() {
        return this.strzalyPrzeciwnika;
    }

    public void setStrzalyPrzeciwnika(Integer strzalyPrzeciwnika) {
        this.strzalyPrzeciwnika = strzalyPrzeciwnika;
    }

    public Integer getPosiadanieWlasne() {
        return this.posiadanieWlasne;
    }

    public void setPosiadanieWlasne(Integer posiadanieWlasne) {
        this.posiadanieWlasne = posiadanieWlasne;
    }

    public Integer getPosiadaniePrzeciwnika() {
        return this.posiadaniePrzeciwnika;
    }

    public void setPosiadaniePrzeciwnika(Integer posiadaniePrzeciwnika) {
        this.posiadaniePrzeciwnika = posiadaniePrzeciwnika;
    }

    public Integer getZolteWlasne() {
        return this.zolteWlasne;
    }

    public void setZolteWlasne(Integer zolteWlasne) {
        this.zolteWlasne = zolteWlasne;
    }

    public Integer getZoltePrzeciwnika() {
        return this.zoltePrzeciwnika;
    }

    public void setZoltePrzeciwnika(Integer zoltePrzeciwnika) {
        this.zoltePrzeciwnika = zoltePrzeciwnika;
    }

    public Integer getCzerwoneWlasne() {
        return this.czerwoneWlasne;
    }

    public void setCzerwoneWlasne(Integer czerwoneWlasne) {
        this.czerwoneWlasne = czerwoneWlasne;
    }

    public Integer getCzerwonePrzeciwnika() {
        return this.czerwonePrzeciwnika;
    }

    public void setCzerwonePrzeciwnika(Integer czerwonePrzeciwnika) {
        this.czerwonePrzeciwnika = czerwonePrzeciwnika;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getPrzebiegnietyDystans() {
        return this.przebiegnietyDystans;
    }

    public void setPrzebiegnietyDystans(BigDecimal przebiegnietyDystans) {
        this.przebiegnietyDystans = przebiegnietyDystans;
    }

    public Integer getIloscKibicow() {
        return this.iloscKibicow;
    }

    public void setIloscKibicow(Integer iloscKibicow) {
        this.iloscKibicow = iloscKibicow;
    }
    public Object getColumnValue(int i) {
        switch (i) {
            case 1:
                return idMecz;
            case 2:
                return przeciwnik;
            case 3:
                return bramkiStrzelone;
            case 4:
                return bramkiStracone;
            case 5:
                return strzalyWlasne;
            case 6:
                return strzalyPrzeciwnika;
            case 7:
                return posiadanieWlasne;
            case 8:
                return posiadaniePrzeciwnika;
            case 9:
                return zolteWlasne;
            case 10:
                return zoltePrzeciwnika;
            case 11:
                return czerwoneWlasne;
            case 12:
                return czerwonePrzeciwnika;
            case 13:
                return data;
            case 14:
                return przebiegnietyDystans;
            default:
                return iloscKibicow;
        }
    }

    public String getColumnName(int i) {
        switch (i) {
            case 1:
                return "idMecz";
            case 2:
                return "przeciwnik";
            case 3:
                return "bramkiStrzelone";
            case 4:
                return "bramkiStracone";
            case 5:
                return "strzalyWlasne";
            case 6:
                return "strzalyPrzeciwnika";
            case 7:
                return "posiadanieWlasne";
            case 8:
                return "posiadaniePrzeciwnika";
            case 9:
                return "zolteWlasne";
            case 10:
                return "zoltePrzeciwnika";
            case 11:
                return "czerwoneWlasne";
            case 12:
                return "czerwonePrzeciwnika";
            case 13:
                return "data";
            case 14:
                return "przebiegnietyDystans";
            default:
                return "iloscKibicow";
        }
    }
}
