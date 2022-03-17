package com.example.validatefrom.controller;

import com.example.validatefrom.model.User;
import com.example.validatefrom.service.IUserService;
import com.example.validatefrom.validate.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("/user")
    public ModelAndView listUser(@PageableDefault(value = 3) Pageable pageable) {
        Page<User> userPage = iUserService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("userList", userPage);
        return modelAndView;
    }


    @GetMapping("/add")
        public ModelAndView createUser( ) {
            ModelAndView modelAndView = new ModelAndView("/create");
            modelAndView.addObject("userDto", new UserDto());
            return modelAndView;
        }

    @PostMapping("/add")
    public String saveUser(@ModelAttribute @Validated UserDto userDto, BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()){
            return "create";
        }else {
            User user=new User();
            BeanUtils.copyProperties(userDto,user);
            iUserService.save(user);
            redirectAttributes.addFlashAttribute("message","Create user "+user.getLastname()+user.getFirstname()+" OK!");
            return "redirect:user";
        }

    }
}
