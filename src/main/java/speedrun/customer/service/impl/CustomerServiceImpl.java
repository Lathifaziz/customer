package speedrun.customer.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import speedrun.customer.Repository.CustomerRepository;
import speedrun.customer.model.Customer;
import speedrun.customer.service.CustomerService;
import speedrun.customer.utill.specification.CustomerSpecification;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository custRepo;

    @Override
    public Page<Customer> getAll(String name, LocalDate birthDate, Pageable pageable) {
        Specification<Customer> spec = CustomerSpecification.getSpecification(birthDate, name);
        return custRepo.findAll(spec, pageable);
    }

    @Override
    public Customer getOne(Integer id) {
        return custRepo.findById(id).orElseThrow(()->new RuntimeException("customer not found"));
    }

    @Override
    public Customer create(Customer req) {
        return custRepo.save(req);
    }

    @Override
    public Customer update(Integer id, Customer req) {
        Customer cUpdate = this.getOne(id);
        cUpdate.setName(req.getName());
        cUpdate.setBirthDate(req.getBirthDate());
        cUpdate.setBalance(req.getBalance());
        custRepo.save(cUpdate);
        return cUpdate;
    }

    @Override
    public void delete(Integer id) {
        custRepo.deleteById(id);
    }
}
