package com.abhimisraw.BigBlog.service;

import com.abhimisraw.BigBlog.domain.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserForm {

    @Email
    private String email;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public User toUser(UserForm userForm){
        User user = new User();
        user.setUserName(userForm.getUsername());
        user.setRole("USER");
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        return user;
    }
}
