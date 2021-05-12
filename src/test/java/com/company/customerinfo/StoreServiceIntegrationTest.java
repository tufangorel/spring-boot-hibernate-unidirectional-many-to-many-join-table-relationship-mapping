package com.company.customerinfo;


import com.company.customerinfo.model.Product;
import com.company.customerinfo.model.Store;
import com.company.customerinfo.service.StoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = CustomerInfoApplication.class)
@ActiveProfiles("dev")
public class StoreServiceIntegrationTest {

    @Autowired
    private StoreService storeService;

    @Test
    public void saveCustomerWithOrderTest() {

        Store store = new Store();
        Product product1 = new Product();
        product1.setName("product1");
        Product product2 = new Product();
        product2.setName("product2");
        Product product3 = new Product();
        product3.setName("product3");
        store.addProduct(product1);
        store.addProduct(product2);
        store.addProduct(product3);

        Store savedRecord = storeService.saveStoreWithProducts(store);
        assertThat( savedRecord != null);
        assertThat( savedRecord.getProducts() != null);
    }
}
