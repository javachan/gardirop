package com.oguzhanuzman.github.gardirop.controller.rest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@Getter
@Setter
public class MemberCreateDto {
    @Length(min = 3, max = 255, message = "Screen name should be least 3, most 255 characters long!")
    @NotEmpty(message = "Screen name shouldn't be empty!")
    private String screenName;
    @Length(min = 3, max = 255, message = "Username should be least 3, most 255 characters long!")
    @NotEmpty(message = "Username shouldn't be empty!")
    private String username;
    @Length(min = 8, message = "Password should be least 8 characters long!")
    @Pattern(regexp = "(?=.*\\p{Lu})(?=.*\\p{Ll})(?=.*[!@#$&*])(?=.*[0-9]).*", message = "Password should contains one upper case, one lower case, one special character and one alphanumeric character!")
    @NotEmpty(message = "Password shouldn't be empty!")
    private String password;
}