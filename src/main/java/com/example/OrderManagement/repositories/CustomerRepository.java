package com.example.OrderManagement.repositories;

import com.example.OrderManagement.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    @Query("{name:'?0'}")
    Customer findCustomerByName(String name);

    @Query(value="{address:'?0'}", fields="{'name' : 1, 'email' : 1}")
    List<Customer> findByAddress(String address);

    @Query(value = "{customer_id: ?0}", fields = "{'customer_id' : 1, 'name' : 1}")
    Customer findCustomerByCustomer_id(int customer_id);

    @Query(value = "{address: {$regex: ?0}}")
    List<Customer> findCustomerByAddressContaining(String address);

    Customer insert(Customer customer);

    void delete(Customer customer);

    @Query("{customer_id: ?0}")
    void deleteByCustomer_id(int customer_id);

    void update(Customer customer);

    public long count();

}
