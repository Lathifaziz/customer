package speedrun.customer.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import speedrun.customer.model.Course;

public interface CourseService {
    Page<Course> getAll(String name, Integer price, Pageable pageable);
    Course getOne(Integer id);
    Course create(Course req);
    void delete(Integer id);

}
