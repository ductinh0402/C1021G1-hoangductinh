package com.example.productcart.controller;

import com.example.productcart.dto.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {
    CartDto cartDto =new CartDto();
 @RequestMapping("/card")
    public ModelAndView showCart(@SessionAttribute(name="cart",required = false )CartDto cartDto){
     return new ModelAndView("/cart","cart",cartDto);
 }


}
