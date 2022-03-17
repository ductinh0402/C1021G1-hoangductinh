package com.example.saveuser.controller;

import com.example.saveuser.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class LoginController {
    @ModelAttribute("user")
    public User initUser() {
        return new User();
    }

    @GetMapping("/login")
    public ModelAndView listUser(@CookieValue(value = "setUser", defaultValue = "") String setUser) {
        Cookie cookie = new Cookie("setUser", setUser);
        return new ModelAndView("/login", "cookieValue", cookie);
    }
    @PostMapping("/dologin")
    public String doLogin(@ModelAttribute("user") User user, Model model, @CookieValue(value = "setUser", defaultValue = "") String setUser,
                          HttpServletResponse response, HttpServletRequest request) {
        if (user.getEmail().equals("admin@gmail.com") && user.getPassword().equals("12345")){
            if (user.getEmail()!=null){
                setUser=user.getEmail();
            }
            Cookie cookie=new Cookie("setUser",setUser);
            cookie.setMaxAge(60*60*24);
            response.addCookie(cookie);
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie1 : cookies) {
                if (cookie1.getName().equals("setUser")){
                    model.addAttribute("cookieValue",cookie1);
                    break;
                }else {
                    cookie1.setValue("");
                    model.addAttribute("cookieValue",cookie1);
                    break;
                }

            }
            model.addAttribute("message",
                    "Login success. Welcome");
        }else{
            user.setEmail("");
            Cookie cookie=new Cookie("serUser",setUser);
            model.addAttribute("cookieValue", cookie);
            model.addAttribute("message", "Login failed. Try again.");
        }
        return "/login";
    }
}
