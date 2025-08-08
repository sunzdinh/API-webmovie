package com.project.webmovie.dto.request;
import com.project.webmovie.entity.User;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class UserCreationRequest {
   String username;
   /* @Pattern(regexp = "^[\\w.+\\-]+@gmail.com",message = "Email phải có định dạng @gmail.com")
    //Giải thích cái cụm "": ^: áp dụng từ đâù chuỗi k bỏ qua kí tự nào trong []
    // []:cho phép dùng bất kỳ kí tự nào bên trong
    // \w: viết tắt của word character
    // \\-: thêm \\ vid dấu - có ý nghĩa là từ .. đến .. VD: [a-z] trong []
    // + : phải có ít nhất 1 ký tự hợp lệ trong [] thì mới @gmail.com được
    */

    String email;
    @Size(min=8,message = "Mật khẩu phải có ít nhất 8 kí tự")
     @Pattern(regexp = ".*[!@#$%^&*()_+\\-={}\\[\\]:\";'<>?,./`~\\\\].*",message = "Mật khẩu phải có ít nhất 1 kí tự đặc biệt")
      // .* là để lấy bất kỳ chuỗi nào kể cả rỗng
      // [].* ý nghĩa giống cái email ở trên
    String password;
    User.Accountrole quyennguoidung;
    private LocalDateTime createdAt=LocalDateTime.now();

    public UserCreationRequest(){
        this.createdAt=LocalDateTime.now();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User.Accountrole getQuyennguoidung() {
        return quyennguoidung;
    }

    public void setQuyennguoidung(User.Accountrole quyennguoidung) {
        this.quyennguoidung = quyennguoidung;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
