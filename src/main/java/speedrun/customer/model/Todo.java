package speedrun.customer.model;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.core.ParameterizedTypeReference;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Todo {
        @Id
    private Integer id;
    private Integer userId;
    private String title;
    private Boolean completed;

}
