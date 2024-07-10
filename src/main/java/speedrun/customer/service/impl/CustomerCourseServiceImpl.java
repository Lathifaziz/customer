package speedrun.customer.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import speedrun.customer.Repository.CustomerCourseRepository;
import speedrun.customer.model.Course;
import speedrun.customer.model.Customer;
import speedrun.customer.model.CustomerCourse;
import speedrun.customer.service.CourseService;
import speedrun.customer.service.CustomerCourseService;
import speedrun.customer.service.CustomerService;
import speedrun.customer.utill.DTO.CustomerCourseDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerCourseServiceImpl implements CustomerCourseService {
    private final CustomerCourseRepository repo;
    private final CustomerService service;
    private final CourseService courseService;

    @Override
    public List<CustomerCourse> getAll() {
        return List.of();
    }

    @Override
    public CustomerCourse getOne(Integer id) {
        return null;
    }

    @Override
    public CustomerCourse create(CustomerCourseDTO req) {
        Customer c = service.getOne(req.getCustomer_id());
        Course course = courseService.getOne(req.getCourse_id());

        CustomerCourse customerCourse = new CustomerCourse();
        customerCourse.setCustomer(c);
        customerCourse.setCourse(course);
//untuk mengurangi balance
        c.setBalance(c.getBalance() - course.getPrice());
        if(c.getBalance()< 0){
            throw new RuntimeException("opps balance tidak cukup");
        }
        service.update(c.getId(),c);

        return repo.save(customerCourse);
    }

    @Override
    public void delete(Integer id) {

    }
}
