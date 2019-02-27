package com.codecool.shop.dao.implementation;

import com.codecool.shop.model.Supplier;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SupplierDaoMemTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testSupplierIDNotNull(){
        Supplier supplier = new Supplier("test case", "test description");
        assertNotNull(supplier.getId());
    }

    @Test
    public void testNameNotNull(){
        Supplier supplier = new Supplier("test name", "test description2");
        assertNotNull(supplier.getName());
    }

    @Test
    public void testAddSupplier(){
        Supplier supplier = new Supplier("test name", "test description");

    }

}
