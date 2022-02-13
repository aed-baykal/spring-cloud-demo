package ru.gb.eurekaclientview;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class ProductController {

    private final ClientRest clientRest;

    public ProductController(ClientRest clientRest) {
        this.clientRest = clientRest;
    }

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        List<Product> products = clientRest.getAllProducts();
        model.addAttribute("products", products);
        return "product_list";
    }

    @GetMapping("/info/{id}")
    public String getProductInfo(@PathVariable Long id, Model model) {
        model.addAttribute("product", clientRest.getProductById(id).orElse(null));
        return "product_info";
    }

    @GetMapping("/add")
    public String getProductAddFrom(Model model) {
        model.addAttribute("product", new Product());
        return "product_form";
    }

    @PostMapping("/add")
    public String saveProduct(Product product) {
        clientRest.saveProduct(product);
        return "redirect:/all";
    }

    @GetMapping("/change/{id}")
    public String getProductChangeFrom(@PathVariable Long id, Model model) {
        model.addAttribute("product", clientRest.getProductById(id).orElse(null));
        return "product_form";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        clientRest.deleteProductById(id);
        return "redirect:/all";
    }

}
