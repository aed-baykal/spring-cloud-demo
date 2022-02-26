package ru.gb.eurekaclientview;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.modelapi.ProductDto;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {

    private final ClientRest clientRest;
    private final static String REDIRECT_GATEWAY = "redirect:http://localhost:5555/all";

    public ProductController(ClientRest clientRest) {
        this.clientRest = clientRest;
    }

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        List<ProductDto> productDtos = clientRest.getAllProducts();
        model.addAttribute("productDtos", productDtos);
        return "product_list";
    }

    @GetMapping("/info/{id}")
    public String getProductInfo(@PathVariable Long id, Model model) {
        model.addAttribute("productDto", clientRest.getProductById(id).orElse(null));
        return "product_info";
    }

    @GetMapping("/add")
    public String getProductAddFrom(Model model) {
        model.addAttribute("productDto", new ProductDto());
        return "product_form";
    }

    @PostMapping("/add")
    @Transactional
    public String saveProduct(@Valid ProductDto productDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "product_form";
        }
        clientRest.saveProduct(productDto);
        return REDIRECT_GATEWAY;
    }

    @GetMapping("/change/{id}")
    public String getProductChangeFrom(@PathVariable Long id, Model model) {
        model.addAttribute("productDto", clientRest.getProductById(id).orElse(null));
        return "product_form";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        clientRest.deleteProductById(id);
        return REDIRECT_GATEWAY;
    }

}
