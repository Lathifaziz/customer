package speedrun.customer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import speedrun.customer.model.Customer;
import speedrun.customer.service.CustomerCourseService;
import speedrun.customer.service.CustomerService;
import speedrun.customer.utill.DTO.CustomerCourseDTO;
import speedrun.customer.utill.response.PageWrapper;
import speedrun.customer.utill.response.Res;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerCourseService ccService;

    @PostMapping("/buy")
    public ResponseEntity<?> buy(@RequestBody CustomerCourseDTO customer){
        return Res.renderJson(
                ccService.create(customer),
                "success buy",
                HttpStatus.CREATED
        );
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Customer req){
        return Res.renderJson(
                customerService.create(req),
                "create",
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public Customer getOne(@PathVariable Integer id){
        return customerService.getOne(id);
    }

    @GetMapping
    public ResponseEntity<?> getAll(
            @RequestParam (required = false) String name,
            @RequestParam (required = false) String birthDate,
            @PageableDefault(page = 0, size = 10) Pageable pageable
    ){
        LocalDate parseDate= null;
        Page<Customer> res = customerService.getAll(name,parseDate,pageable);
        PageWrapper<Customer> result = new PageWrapper<>(res);
        return Res.renderJson(
               result,
                 "FOUND",
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable Integer id, @RequestBody Customer req){
        return customerService.update(id,req);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id){
        customerService.delete(id);
    }
}
