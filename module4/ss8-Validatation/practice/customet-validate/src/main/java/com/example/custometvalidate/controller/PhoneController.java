package com.example.custometvalidate.controller;

import com.example.custometvalidate.Validate.PhoneDto;
import com.example.custometvalidate.model.Phone;
import com.example.custometvalidate.service.IPhoneService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class PhoneController {
    @Autowired
    private IPhoneService iPhoneService;

    @GetMapping("/phone")
    public ModelAndView listPhone(@PageableDefault(size = 2) Pageable pageable) {
        Page<Phone> phonePage = iPhoneService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("phoneList", phonePage);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addPhone() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("phoneDto", new PhoneDto());
        return modelAndView;
    }

    @PostMapping("/add")
    public String savePhone(@ModelAttribute @Validated PhoneDto phoneDto,
                            BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        new PhoneDto().validate(phoneDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/create";
        } else {
            Phone phone = new Phone(phoneDto.getNumberPhone());
            BeanUtils.copyProperties(phoneDto, phone);

//            phone.setNumberPhone(Double.valueOf(phoneDto.getNumberPhone()));
            iPhoneService.save(phone);
        redirectAttributes.addFlashAttribute("message","Create phone "+ phone.getName()+" OK!");
            return "redirect:/phone";
        }
    }
}
