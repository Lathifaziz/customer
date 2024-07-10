package speedrun.customer.service;

import speedrun.customer.model.CustomerCourse;
import speedrun.customer.utill.DTO.CustomerCourseDTO;

import java.util.List;

public interface CustomerCourseService {
    List<CustomerCourse> getAll();
    CustomerCourse getOne(Integer id);
    CustomerCourse create(CustomerCourseDTO req);
    void delete(Integer id);
}
