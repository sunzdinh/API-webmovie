package com.project.webmovie.dto.request;
import java.time.LocalDateTime;

public class MovieCreationRequest {
    private String tieude;
    private String mota;
    private  int namphathanh;
    private int thoiluong;
    private  String duongdan_url;
    private String trailer_url;
    private LocalDateTime creata_at = LocalDateTime.now();
    public MovieCreationRequest(){
        this.creata_at=LocalDateTime.now();
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

    public LocalDateTime getCreata_at() {
        return creata_at;
    }

    public void setCreata_at(LocalDateTime creata_at) {
        this.creata_at = creata_at;
    }

}
