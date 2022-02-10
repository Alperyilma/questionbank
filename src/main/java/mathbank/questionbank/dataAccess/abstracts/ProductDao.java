package mathbank.questionbank.dataAccess.abstracts;

import mathbank.questionbank.entities.conceretes.Category;
import mathbank.questionbank.entities.conceretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {

    List<Product> getByProductName(String productName);
    List<Product> getByCategoryIn(List<Integer> categories);

}
