package com.example.validateinforuser.controller;

import com.example.validateinforuser.model.User;
import com.example.validateinforuser.service.IUserService;
import com.example.validateinforuser.vailidateUser.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("/user")
    public ModelAndView listUser(@PageableDefault(size = 2) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("userList", iUserService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createUser() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("userDto", new UserDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public String savaCreate(@ModelAttribute @Validated UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            iUserService.save(user);
            redirectAttributes.addFlashAttribute("mess", "Ban da them " + userDto.getName() + " thanh cong");
//        model.addAttribute("mess", "Ban da them " + user.getName() + " thanh cong");
//        model.addAttribute("user", new User());
            return "redirect:/user";
        }
    }

}
