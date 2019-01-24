import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.springframework.transaction.annotation.Transactional;

import com.axelor.ProductRepository;
import com.axelor.package1.Product;

public class ProductService {
	public static void main(String[] args) {
		
	}

    private ProductRepository productRepository;

    @Inject
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product get(long id) {
        return productRepository.getOne(id);
    }

    public List<Product> listAll() {
        return productRepository.findAll();
    }

    public List<Product> filter(String subString) {
        return productRepository.findByNameContainingIgnoreCase(subString);
    }

    /** @throws IllegalStateException if the entity exists. */
    @Transactional
    public void add(Product product) {
        boolean exists = productRepository.existsById(product.getId());
        if(exists)
            throw new IllegalStateException("Product with id:" + product.getId() + " already exists");
        productRepository.save(product);
    }

    /** @throws IllegalStateException if one of the entities exists. */
    @Transactional
    public void addAll(Collection<Product> products) {
        for (Product product : products) {
            add(product);
        }
    }

}