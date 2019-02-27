import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.model.ProductCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ProductCategoryDaoMemTest {

    private ProductCategoryDao productCategoryDao = ProductCategoryDaoMem.getTestInstance();
    private ProductCategory testCategory1 = new ProductCategory("testCategory1", "testDepartment1", "testDescription");
    private ProductCategory testCategory2 = new ProductCategory("testCategory2", "testDepartment2", "testDescription");


    @BeforeEach
    void clearTestDao () {
        for (int i = 0; i < 10; i++) {
            productCategoryDao.remove(i);
        }
    }


    @Test
    void testAdd() {

        productCategoryDao.add(testCategory1);
        productCategoryDao.add(testCategory2);

        List<ProductCategory> categories = Arrays.asList(testCategory1, testCategory2);

        assertEquals(productCategoryDao.getAll(), categories);
    }


    @Test
    void testFindByName() {

        productCategoryDao.add(testCategory1);

        assertEquals(productCategoryDao.findByName("testCategory1"), testCategory1);
    }


    @Test
    void testRemoveById() {

        testCategory1.setId(1);
        productCategoryDao.add(testCategory1);
        productCategoryDao.remove(1);

        assertNull(productCategoryDao.findByName("testCategory1"));
    }


    @Test
    void testGetAll() {

        productCategoryDao.add(testCategory1);
        productCategoryDao.add(testCategory2);

        List<ProductCategory> testList = Arrays.asList(testCategory1, testCategory2);

        assertEquals(productCategoryDao.getAll(), testList);
    }
}
