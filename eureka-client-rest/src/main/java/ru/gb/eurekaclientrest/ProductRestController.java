package ru.gb.eurekaclientrest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.modelapi.ProductDto;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductRestController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping("/info/{id}")
    public Optional<ProductDto> getProductById(@PathVariable Long id) {
        return Optional.ofNullable(productMapper.productToProductDto(productService.findById(id).orElse(null)));
    }

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productService.getAll().stream().map(productMapper::productToProductDto).toList();
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody ProductDto productDto) {
        productService.save(productMapper.productDtoToProduct(productDto));
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void updateProduct(@RequestBody Product product) {
        productService.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public int deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return HttpStatus.OK.value();
    }

}
