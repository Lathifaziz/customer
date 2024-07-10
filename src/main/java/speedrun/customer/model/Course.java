package speedrun.customer.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "course")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer price;
}
