import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductDaoMemTest {

    private ProductDao productDao = ProductDaoMem.getTestInstance();
    private Supplier testSupplier = new Supplier("testSupplier", "test");
    private ProductCategory testCategory = new ProductCategory("testCategory", "testDepartment", "test");


    @Test
    void testAdd() {

        for (int i = 0; i < 10; i++) {
            Product product = new Product("testProd" + i, 49.9f, "USD", "test.", testCategory, testSupplier);
            productDao.add(product);
        }

        List<Product> products = productDao.getAll();


        for (int i = 0; i < 10; i++) {
            Product product = products.get(i);
            assertEquals(product.getName(), "testProd" + i);
        }

        for (int i = 1; i < 10; i++) {
            productDao.remove(i);
        }
    }


}
