import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ProductDaoMemTest {

    private ProductDao productDao = ProductDaoMem.getTestInstance();
    private Supplier testSupplier1 = new Supplier("testSupplier1", "test");
    private Supplier testSupplier2 = new Supplier("testSupplier2", "test");
    private ProductCategory testCategory = new ProductCategory("testCategory", "testDepartment", "test");
    private Product testProduct1 = new Product("testProd1", 9.9f, "USD", "test.", testCategory, testSupplier1);
    private Product testProduct2 = new Product("testProd2", 4.9f, "USD", "test.", testCategory, testSupplier2);
    private List<Product> testProducts = Arrays.asList(testProduct1, testProduct2);


    @Test
    void testAdd() {

        for (int i = 0; i < 10; i++) {
            Product product = new Product("testProd" + i, 49.9f, "USD", "test.", testCategory, testSupplier1);
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


    @Test
    void testAddV2() {

        List<Product> products = new ArrayList<>();

        products.add(testProduct1);

        assertEquals(testProduct1, products.get(0));

        products.remove(testProduct1);
    }


    @Test
    void testFind() {

        productDao.add(testProduct1);
        assertEquals(productDao.find(2), testProduct1);
        productDao.remove(2);
    }


    @Test
    void testRemove() {

        Product product = new Product("testProd", 49.9f, "USD", "test.", testCategory, testSupplier1);
        product.setId(5);
        productDao.add(product);

        productDao.remove(5);

        assertNull(productDao.find(5));
    }


    @Test
    void testGetAll() {

        List<Product> products1 = Arrays.asList(testProduct1, testProduct2);

        List<Product> products2 = new ArrayList<>();
        products2.add(testProduct1);
        products2.add(testProduct2);

        assertEquals(products1, products2);
    }


    @Test
    void testGetBySupplier() {

        List<Product> testList = Arrays.asList(testProduct1);

        productDao.add(testProduct1);
        productDao.add(testProduct2);

        assertEquals(productDao.getBy(testSupplier1), testList);
    }

}



