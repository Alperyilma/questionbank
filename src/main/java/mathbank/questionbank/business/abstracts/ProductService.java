package mathbank.questionbank.business.abstracts;

import mathbank.questionbank.entities.conceretes.Category;
import mathbank.questionbank.entities.conceretes.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();
    List<Product> getAllSorted();
    Product add(Product product);
    void delete(Product productId);
    List<Product> getByProductName(String productName);
    List<Product> getByCategoryIn(List<Integer> categories);




}
