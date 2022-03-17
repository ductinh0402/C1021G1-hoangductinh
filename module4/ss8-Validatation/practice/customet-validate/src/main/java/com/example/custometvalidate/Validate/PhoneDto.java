package com.example.custometvalidate.Validate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PhoneDto implements Validator {
    private Integer id;
    @NotBlank(message = "Nhap ten dung theo dang")
    private String name;
    @NotNull(message = "khong duoc de trong")
    private String numberPhone;

    public PhoneDto() {
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

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    @Override
    public boolean supports(Class<?> clazz) {

        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        PhoneDto phoneDto = (PhoneDto) target;
        if (phoneDto.getNumberPhone().isEmpty()) {
            errors.rejectValue("numberPhone", "", "Không được để trống");
        }
        if (phoneDto.getNumberPhone().length() < 10 && phoneDto.getNumberPhone().length() > 11) {
            errors.rejectValue("numberPhone", "", "Nhập sdt hợp lệ");
        }
        if (!phoneDto.getNumberPhone().matches("(^$|[0-9]*$)")) {
            errors.rejectValue("numberPhone", "", "Chỉ Bao gồm số");
        }
        if (!(phoneDto.getNumberPhone().startsWith("0"))) {
            errors.rejectValue("numberPhone", "", "Vui lòng nhập số 0 đầy tiên");
        }
    }
}
