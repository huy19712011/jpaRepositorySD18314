package com.example.jparepositorysd18314;

import com.example.jparepositorysd18314.entity.Customer;
import com.example.jparepositorysd18314.entity.PhoneNumber;
import com.example.jparepositorysd18314.entity.Product;
import com.example.jparepositorysd18314.repository.CustomerRepository;
import com.example.jparepositorysd18314.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class JpaRepositorySd18314Application implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(getClass());

    final
    CustomerRepository customerRepository;

    final
    ProductRepository repository;

    public JpaRepositorySd18314Application(ProductRepository repository, CustomerRepository customerRepository) {
        this.repository = repository;
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaRepositorySd18314Application.class, args);
        System.out.println("running...");
    }

    @Override
    public void run(String... args) throws Exception {

/*
        logger.info("Ok");

        // 1. Methods: save
        Product product = new Product();
        product.setName("Product 1");

        Product savedProduct = repository.save(product);

        repository.findAll().forEach(p -> logger.info(p.toString()));

        // 2. containing

        repository.findByNameContaining("Product 101").forEach(p -> logger.info(p.toString()));

        //3. Query creation
        // JPQL
        // Native Query


        //4. Named quies


        //5. Pagination
        int pageNo = 0; //default, 0, 1, 2, ...
        int pageSize = 5; // size of 1 page

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        // get all info via Page object
        Page<Product> page = repository.findAll(pageable);

        // all of page 0
        List<Product> products = page.getContent();
        products.forEach(p -> logger.info(p.toString()));

        // total pages
        int totalPages = page.getTotalPages();
        logger.info("Total Pages: " + totalPages);

        // total elements
        long totalElements = page.getTotalElements();
        logger.info("Total elements: " + totalElements);

        // size
        int size = page.getSize();
        logger.info("Size: " + size);

        // last, first
        boolean isLast = page.isLast();
        logger.info("isLast: " + isLast);


        // 6. Sorting
        List<Product> products1 = repository.findAll(Sort.by("name").descending());
        products1.forEach(p -> logger.info(p.toString()));

        //
        String sortBy = "name";
        String sortDir = "asc";
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy) : Sort.by(sortBy).descending();
        List<Product> products2 = repository.findAll(sort);
        products2.forEach(p -> logger.info(p.toString()));

        // sorting with multiple fields => name + nickName
        // Sort.by("name").descending().and(Sort.by("nickName").descending());


        // 7. Pagination + Sorting
        Page<Product> products3 = repository.findAll(PageRequest.of(pageNo, pageSize, sort));
        products3.forEach(p -> logger.info(p.toString()));
*/

        Customer customer = new Customer();
        customer.setName("customer 1");

        HashSet<PhoneNumber> numbers = new HashSet<>();
        PhoneNumber ph1 = new PhoneNumber();
        ph1.setNumber("123456789");
        ph1.setType("home");
        numbers.add(ph1);
        //ph1.setCustomer(customer);

        PhoneNumber ph2 = new PhoneNumber();
        ph2.setNumber("987654321");
        ph2.setType("office");
        numbers.add(ph2);
        //ph2.setCustomer(customer);

        //customer.setNumbers(numbers);
        customer.addPhoneNumber(ph1);
        customer.addPhoneNumber(ph2);

        customerRepository.save(customer);

        // fetching LAZY/EAGER
        Customer customer1 = customerRepository.findById(1L).get();
        System.out.println("customer1: " + customer1.getName());
        System.out.println("customer1: " + customer1.getNumbers());

        // Update
        customer1.setName("customer 11");
        Set<PhoneNumber> phoneNumbers = customer1.getNumbers();
        phoneNumbers.forEach(number -> number.setType("Cell"));
        customerRepository.save(customer1);

        // delete
        customerRepository.delete(customer1);


    }
}
