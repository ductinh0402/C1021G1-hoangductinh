package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @GetMapping("")
    public String index() {
        return "home";
    }

    public Map<String, String> dictionary() {
        Map<String, String> dictionaryMap = new HashMap<>();
        dictionaryMap.put("Fruit", "Trái cây");
        dictionaryMap.put("Book", "Sách");
        dictionaryMap.put("Foreigner", "Người nước ngoài");
        dictionaryMap.put("Confident", "Tự tin");
        dictionaryMap.put("Shy", "Xấu hổ");
        dictionaryMap.put("Culture", "Văn hóa");
        dictionaryMap.put("Skill", "Kỹ năng");
        dictionaryMap.put("Murder", "Giết người");
        dictionaryMap.put("Steal", "Ăn trộm");
        dictionaryMap.put("Gun", "Súng");
        dictionaryMap.put("Prisoner", "Tù nhân");
        return dictionaryMap;
    }

    @GetMapping("result")
    public ModelAndView showList(@RequestParam String english) {
        ModelAndView modelAndView = new ModelAndView("/home");
        Map<String, String> dictionaryControllers = dictionary();
        for (Map.Entry<String, String> stringStringEntry : dictionaryControllers.entrySet()) {
            if (stringStringEntry.getKey().equals(english)) {
                modelAndView.addObject("vn", stringStringEntry.getValue());
            } else {
                modelAndView.addObject("result", "Bạn nhập sai rồi!");
            }
        }
        return modelAndView;
    }
}
