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
    private ProductCategory testCategory1 = new ProductCategory("testCategory", "testDepartment", "test");
    private ProductCategory testCategory2 = new ProductCategory("testCategory", "testDepartment", "test");
    private Product testProduct1 = new Product("testProd1", 9.9f, "USD", "test.", testCategory1, testSupplier1);
    private Product testProduct2 = new Product("testProd2", 4.9f, "USD", "test.", testCategory2, testSupplier2);
    private List<Product> testProducts = Arrays.asList(testProduct1, testProduct2);


    @BeforeEach
    void clearTestDao() {
        for (int i = 0; i < 10; i++) {
            productDao.remove(i);
        }
    }


    @Test
    void testAdd() {

        for (int i = 0; i < 10; i++) {
            Product product = new Product("testProd" + i, 49.9f, "USD", "test.", testCategory1, testSupplier1);
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


//    @Test
//    void testAddV2() {
//
//        List<Product> products = new ArrayList<>();
//
//        products.add(testProduct1);
//
//        assertEquals(testProduct1, products.get(0));
//    }


    @Test
    void testFind() {

        productDao.add(testProduct1);
        assertEquals(productDao.find(2), testProduct1);
        productDao.remove(2);
    }


    @Test
    void testRemove() {

        Product product = new Product("testProd", 49.9f, "USD", "test.", testCategory1, testSupplier1);
        product.setId(5);
        productDao.add(product);

        productDao.remove(5);

        assertNull(productDao.find(5));
    }


    @Test
    void testGetAll() {

        List<Product> testProducts = Arrays.asList(testProduct1, testProduct2);

        for (int i = 0; i < 20; i++) {
            productDao.remove(i);
        }

        productDao.add(testProduct1);
        productDao.add(testProduct2);

        assertEquals(productDao.getAll(), testProducts);
    }


    @Test
    void testGetBySupplier() {

        List<Product> testList = Arrays.asList(testProduct1);

        productDao.add(testProduct1);
        productDao.add(testProduct2);

        assertEquals(productDao.getBy(testSupplier1), testList);

        productDao.remove(1);
        productDao.remove(2);
    }


    @Test
    void testGetByProductCategory() {

        List<Product> testList = Arrays.asList(testProduct1);

        productDao.add(testProduct1);
        productDao.add(testProduct2);

        assertEquals(productDao.getBy(testCategory1), testList);

        productDao.remove(1);
        productDao.remove(2);
    }

}
