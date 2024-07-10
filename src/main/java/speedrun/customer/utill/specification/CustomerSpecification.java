package speedrun.customer.utill.specification;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import speedrun.customer.model.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerSpecification {
    public static Specification<Customer> hasName(String name){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("name"), "%"+name+"%");
    }

    public static Specification<Customer> hasBirtDate(LocalDate birthDate){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("birthDate"), birthDate);
    }
    public static Specification<Customer>getSpecification(LocalDate birthDate, String name){
      return ((root, query, criteriaBuilder) -> {
          List<Predicate> p = new ArrayList<>();

          if (name != null && !name.isEmpty()) {
              p.add(criteriaBuilder.like(root.get("name"),"%"+name+"%"));
          }
          if(birthDate != null) {
          p.add(criteriaBuilder.equal(root.get("birthdate"),birthDate));
          }
          return criteriaBuilder.and(p.toArray(new Predicate[0]));
      });
    }

}


