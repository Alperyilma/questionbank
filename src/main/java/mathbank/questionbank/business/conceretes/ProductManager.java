package mathbank.questionbank.business.conceretes;

import mathbank.questionbank.business.abstracts.ProductService;
import mathbank.questionbank.dataAccess.abstracts.ProductDao;
import mathbank.questionbank.entities.conceretes.Category;
import mathbank.questionbank.entities.conceretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAll() {
        return this.productDao.findAll();
    }

    @Override
    public List<Product> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "productId");
        return this.productDao.findAll(sort);

    }

    @Override
    public Product add(Product product) {
        return this.productDao.save(product);
    }

    @Override
    public void delete(Product productId) {
        this.productDao.delete(productId);
    }


    @Override
    public List<Product> getByProductName(String productName) {
        return this.productDao.getByProductName(productName);
    }

    @Override
    public List<Product> getByCategoryIn(List<Integer> categories) {
        return productDao.getByCategoryIn(categories);
    }


}
