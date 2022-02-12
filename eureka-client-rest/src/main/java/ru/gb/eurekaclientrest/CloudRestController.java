package ru.gb.eurekaclientrest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CloudRestController {

//    @Value("${config.name}")
    String name = "World";

    @GetMapping("/rest")
    public String getName(){
        return name;
    }

    @GetMapping("/param/{id}")
    public Integer getName(@PathVariable Integer id){
        return id;
    }
//    private ProductService productService;
//
//    @Autowired
//    public void setProductService(ProductService productService) {
//        this.productService = productService;
//    }
//
//    @GetMapping("/{id}")
//    public Optional<Product> getProductById(@PathVariable Long id) {
//        return productService.findById(id);
//    }
//
//    @GetMapping
//    public List<Product> getAllProducts() {
//        return productService.getAll();
//    }
//
//    @PostMapping
//    public void addProduct(@RequestBody Product product) {
//        product.setId(0L);
//        productService.save(product);
//    }
//
//    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
//    public void updateProduct(@RequestBody Product product) {
//        productService.save(product);
//    }
//
//    @DeleteMapping("/{id}")
//    public int deleteProduct(@PathVariable Long id) {
//        productService.deleteById(id);
//        return HttpStatus.OK.value();
//    }
}
