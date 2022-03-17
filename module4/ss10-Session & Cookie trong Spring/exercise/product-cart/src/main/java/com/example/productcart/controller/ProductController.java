package com.example.productcart.controller;

import com.example.productcart.dto.CartDto;
import com.example.productcart.dto.ProductDto;
import com.example.productcart.model.Product;
import com.example.productcart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/product")
@SessionAttributes("carts")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    //khoi tao Session
    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @GetMapping("/list")
    public ModelAndView listProduct(@ModelAttribute("cart") CartDto cartDto) {
        return new ModelAndView("/list", "productList", iProductService.findAll());
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewProduct(@PathVariable Long id) {
     return new ModelAndView("/view","product",iProductService.findById(id).get());
    }
     @GetMapping("/add/{id}")
    public  String addCart(@PathVariable Long id ,@ModelAttribute("cart") CartDto cartDto){
         Optional<Product> productOptional=iProductService.findById(id);
         if (productOptional.isPresent()){
             ProductDto productDto=new ProductDto();
             BeanUtils.copyProperties(productOptional.get(),productDto);
             cartDto.addProduct(productDto);
         }
        return "cart";
     }



}
