package controller;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import services.IProductServices;
import services.ProductServices;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductManagementController
{
    private final IProductServices iProductServices = new ProductServices();

    @GetMapping("")
    public String index(Model model) {

        List<Product> productList = iProductServices.findAll();
        model.addAttribute("product", productList);
        return "/index";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product", new Product());
        return "/create";
    }
    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        product.setId((int) (Math.random() * 10000));
        iProductServices.save(product);
        redirectAttributes.addFlashAttribute("success","Bạn đã thêm thành công");
        return "redirect:/product";
    }
    @GetMapping("/{id}/edit")
    public String edit (@PathVariable int id, Model model){
        model.addAttribute("product",iProductServices.findById(id));
        return "/edit";
    }
    @PostMapping("/update")
    public String update(Product product) {
        iProductServices.update(product.getId(), product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductServices.findById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        iProductServices.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/product";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductServices.findById(id));
        return "/view";
    }
    @PostMapping("/search")
    public String search(@RequestParam String name, Model model){
        List<Product> products = iProductServices.searchByName(name);
        if(products.size()==0){
            model.addAttribute("success","không tìm thấy");
        }
        model.addAttribute("product",products);
        return "/index";
    }
}
