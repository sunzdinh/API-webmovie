package com.project.webmovie.dto.request;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class MovieCreationRequest {

    @NotBlank(message = "Tiêu đề phim không được để trống")
    @Size(max = 255, message = "Tiêu đề không được quá 255 ký tự")
    private String tieude;

    @Size(max = 1000, message = "Mô tả không được quá 1000 ký tự")
    private String mota;

    @NotNull(message = "Năm phát hành không được để trống")
    @Min(value = 1900, message = "Năm phát hành phải từ 1900 trở lên")
    @Max(value = 2030, message = "Năm phát hành không được quá 2030")
    private Integer namphathanh;

    @NotNull(message = "Thời lượng phim không được để trống")
    @Positive(message = "Thời lượng phim phải > 0")
    private Integer thoiluong; // Đơn vị: phút

    @NotBlank(message = "Đường dẫn phim không được để trống")
    private String duongdan_url;

    private String trailer_url; // Optional

    // Constructor
    public MovieCreationRequest() {}

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