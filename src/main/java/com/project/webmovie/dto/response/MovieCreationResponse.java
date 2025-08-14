package com.project.webmovie.dto.response;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class MovieCreationResponse {

    private String tieude;
    private String mota;
    private Integer namphathanh;
    private Integer thoiluong; // Đơn vị: phút

    private String duongdan_url;

    private String trailer_url; // Optional

    // Constructor
    public MovieCreationResponse() {}

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

    // Không cần getter/setter cho created_at vì sẽ tự động set trong service
    public LocalDateTime getCreata_at() { return LocalDateTime.now(); }
}