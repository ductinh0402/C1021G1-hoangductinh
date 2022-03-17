package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConversionController {
    @GetMapping("")
    public String index() {
        return "home";
    }


    @GetMapping("convert")
    public ModelAndView showList(@RequestParam String usd) {
        if (!usd.isEmpty()) {
            double result = (Double.parseDouble(usd)) * 23000;

            ModelAndView modelAndView = new ModelAndView("home");
            modelAndView.addObject("result", result);

            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("home");
            modelAndView.addObject("result", "Vui long nhap lai!");

            return modelAndView;
        }
    }
}
