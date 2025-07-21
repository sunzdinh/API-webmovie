package com.project.webmovie.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity

@Table(name = "MOVIE")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column( name="ID")
    private int id;
    @Column( name="TIEUDE")
    private String tieude;
    @Column( name="MOTA")
    private String mota;
    @Column( name="NAMPHATHANH")
    private int namphathanh;
    @Column( name="THOILUONG")
    private int thoiluong;
    @Column( name="DUONGDAN")
    private String duongdan_url ;
    @Column( name="TRAILER_URL")
    private String trailer_url ;
    @Column( name="CREATED_AT", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getNamphathanh() {
        return namphathanh;
    }

    public void setNamphathanh(int namphathanh) {
        this.namphathanh = namphathanh;
    }

    public int getThoiluong() {
        return thoiluong;
    }

    public void setThoiluong(int thoiluong) {
        this.thoiluong = thoiluong;
    }

    public String getDuongdan_url() {
        return duongdan_url;
    }

    public void setDuongdan_url(String duongdan_url) {
        this.duongdan_url = duongdan_url;
    }

    public String getTrailer_url() {
        return trailer_url;
    }

    public void setTrailer_url(String trailer_url) {
        this.trailer_url = trailer_url;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
