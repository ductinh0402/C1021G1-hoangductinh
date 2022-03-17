package com.example.validateinforuser.vailidateUser;

import javax.validation.constraints.*;

public class UserDto{
    private Integer id;
    @NotBlank(message = "khong duoc de trong")
    @Size(min = 2, max = 30,message = "nhap tu 2 den 30")
    private String name;
    @NotNull(message = "khong duoc de trong")
    @Min(value = 18,message = "nhap tren 18 tuoi")
    private Integer age;

    public UserDto(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public UserDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

//    @Override
//    public boolean supports(Class<?> clazz) {
//        return false;
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        UserDto userDto = (UserDto) target;
//        if (userDto.getAge() <= 18) {
//            errors.rejectValue("age", "", "Nhap tuoi tu 18 tro len");
//        }
//    }
}
