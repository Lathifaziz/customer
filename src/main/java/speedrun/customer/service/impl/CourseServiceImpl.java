package speedrun.customer.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import speedrun.customer.Repository.CourseRepository;
import speedrun.customer.model.Course;
import speedrun.customer.service.CourseService;
import speedrun.customer.utill.specification.CourseSpecification;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    public final CourseRepository repoCour;

    @Override
    public Page<Course> getAll(
            String name,
            Integer price,
            Pageable pageable)
    {
        Specification<Course> spec = CourseSpecification.getSpecification(name, price);
        return repoCour.findAll(spec,pageable);
    }

    @Override
    public Course getOne(Integer id) {
        return repoCour.findById(id).orElseThrow(() -> new RuntimeException("course not found"));
    }

    @Override
    public Course create(Course req) {
        return repoCour.save(req);
    }

    @Override
    public void delete(Integer id) {
        repoCour.deleteById(id);
    }
}
