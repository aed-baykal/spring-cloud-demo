package ru.gb.eurekaclientview;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.gb.modelapi.ProductDto;

import java.util.List;
import java.util.Optional;

@FeignClient("eureka-client-rest")
public interface ClientRest {

    @GetMapping("/products/info/{id}")
    Optional<ProductDto> getProductById(@PathVariable Long id);

    @GetMapping("/products/")
    List<ProductDto> getAllProducts();

    @PostMapping("/products/add")
    void saveProduct(@RequestBody ProductDto productDto);

    @PutMapping(path = "/products/", consumes = {MediaType.APPLICATION_JSON_VALUE})
    void updateProduct(@RequestBody ProductDto productDto);

    @DeleteMapping("/products/delete/{id}")
    void deleteProductById(@PathVariable Long id);
}
