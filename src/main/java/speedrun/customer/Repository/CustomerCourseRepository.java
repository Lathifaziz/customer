package speedrun.customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import speedrun.customer.model.CustomerCourse;

@Repository
public interface CustomerCourseRepository extends JpaRepository<CustomerCourse, Integer> {
}
