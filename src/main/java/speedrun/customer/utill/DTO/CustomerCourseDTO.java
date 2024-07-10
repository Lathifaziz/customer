package speedrun.customer.utill.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CustomerCourseDTO {
    private Integer customer_id;
    private Integer course_id;
}