package speedrun.customer.utill.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WebResponse <T> {
    private String status;
    private String massage;
    private T data;
}
