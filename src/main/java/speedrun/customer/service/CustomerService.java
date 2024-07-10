package speedrun.customer.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import speedrun.customer.model.Customer;

import java.time.LocalDate;
import java.util.List;

public interface CustomerService {
    Page<Customer> getAll(String name, LocalDate birthDate, Pageable pageable);
    Customer getOne(Integer id);
    Customer create(Customer req);
    Customer update(Integer id,Customer req);
    void delete(Integer id);
}
