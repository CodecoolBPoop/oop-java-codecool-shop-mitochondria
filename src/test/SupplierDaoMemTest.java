import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Supplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SupplierDaoMemTest {

    private SupplierDao supplierDao = SupplierDaoMem.getTestInstance();
    private Supplier testSupplier1 = new Supplier("testSupplier1", "test description");
    private Supplier testSupplier2 = new Supplier("testSupplier2", "test description");


    @BeforeEach
    void clearTestDao() {

        for (int i = 0; i < 10; i++) {
            supplierDao.remove(i);
        }
    }


    @Test
    void testAdd() {

        supplierDao.add(testSupplier1);
        supplierDao.add(testSupplier2);

        List<Supplier> suppliers = Arrays.asList(testSupplier1, testSupplier2);

        assertEquals(supplierDao.getAll(), suppliers);
    }


    @Test
    void testFindById() {

        testSupplier1.setId(1);
        supplierDao.add(testSupplier1);
        supplierDao.add(testSupplier2);

        assertEquals(supplierDao.find(1), testSupplier1);
    }


    @Test
    void testFindByName() {

        supplierDao.add(testSupplier1);
        supplierDao.add(testSupplier2);

        assertEquals(supplierDao.findByName("testSupplier1"), testSupplier1);
    }


    @Test
    void testRemoveById() {

        testSupplier1.setId(1);
        supplierDao.add(testSupplier1);
        supplierDao.add(testSupplier2);
        supplierDao.remove(1);

        assertNull(supplierDao.findByName(testSupplier1.getName()));
    }


    @Test
    void testGetAll() {

        supplierDao.add(testSupplier1);
        supplierDao.add(testSupplier2);

        List<Supplier> testList = Arrays.asList(testSupplier1, testSupplier2);

        assertEquals(supplierDao.getAll(), testList);
    }
}