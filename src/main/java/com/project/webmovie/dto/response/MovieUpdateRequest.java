package com.project.webmovie.dto.response;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class MovieUpdateRequest {

    private String tieude;
    private String mota;
    private Integer namphathanh;

    private Integer thoiluong;

    private String duongdan_url;
    private String trailer_url;


    public MovieUpdateRequest() {}

    // Getters and Setters
    public String getTieude() { return tieude; }
    public void setTieude(String tieude) { this.tieude = tieude; }

    public String getMota() { return mota; }
    public void setMota(String mota) { this.mota = mota; }

    public Integer getNamphathanh() { return namphathanh; }
    public void setNamphathanh(Integer namphathanh) { this.namphathanh = namphathanh; }

    public Integer getThoiluong() { return thoiluong; }
    public void setThoiluong(Integer thoiluong) { this.thoiluong = thoiluong; }

    public String getDuongdan_url() { return duongdan_url; }
    public void setDuongdan_url(String duongdan_url) { this.duongdan_url = duongdan_url; }

    public String getTrailer_url() { return trailer_url; }
    public void setTrailer_url(String trailer_url) { this.trailer_url = trailer_url; }

    public java.time.LocalDateTime getCreata_at() { return java.time.LocalDateTime.now(); }
}