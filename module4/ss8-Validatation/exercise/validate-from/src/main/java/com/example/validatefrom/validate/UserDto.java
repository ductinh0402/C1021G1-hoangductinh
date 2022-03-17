package com.example.validatefrom.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;


public class UserDto implements Validator {
    private Integer id;
    @Size(min = 5, max = 45, message = "Tối thiểu 5 và tối đa 45")
    @NotBlank(message = "Không được để trống.")
    private String firstname;
    @NotBlank(message = "Không được để trống.")
    private String lastname;
    @Size(min = 10,max = 11,message = "Phải nhập 10 hoặc 11 số")
    @NotBlank(message = "Không được để trống.")
    private String phoneNumber;
    @Min(value = 18,message = "18+")
    @NotBlank(message = "Không được để trống.")
    private String age;
    @NotBlank(message = "Không được để trống.")
    @Email(message = "Đúng quy tắc Email")
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserDto(Integer id, String firstname, String lastname, String phoneNumber, String age, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public UserDto() {
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
         UserDto userDto= (UserDto) target;
         if (!(userDto.getPhoneNumber().matches("(^$|[0-9]*$)") && userDto.getPhoneNumber().startsWith("0"))){
             errors.rejectValue("numberPhone", "", "Chỉ bao gồm số và bắt đầu bằng số 0");
         }
    }
}
