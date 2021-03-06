package mathbank.questionbank.api.controllers;

import lombok.AllArgsConstructor;
import mathbank.questionbank.business.abstracts.ProductService;
import mathbank.questionbank.entities.conceretes.Category;
import mathbank.questionbank.entities.conceretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public List<Product> getAll(){
        return this.productService.getAll();
    }

    @PostMapping("/add")
    public Product add(@RequestBody Product product){
        return this.productService.add(product);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Product productId){
        this.productService.delete(productId);
    }

    @GetMapping("getByProductName")
    public List<Product> getByProductName(@RequestParam String productName){
        return productService.getByProductName(productName);
    }

    @GetMapping("getByProductId")
    public List<Product> getByProductId(@RequestParam int productId) {
        return productService.getByProductId(productId);
    }

    @GetMapping("getAllSorted")
    public List<Product> getAllSorted(){
        return this.productService.getAllSorted();
    }

    @GetMapping("getByCategoryIn")
    public List<Product> getByCategoryIn(@RequestBody List<Integer> categories){
        return this.productService.getByCategoryIn(categories);
    }

}
