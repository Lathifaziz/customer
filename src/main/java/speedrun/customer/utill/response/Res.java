package speedrun.customer.utill.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Res {
    public static <T>ResponseEntity<?> renderJson(T data, String massage, HttpStatus httpStatus){
    WebResponse<T> response = WebResponse.<T>builder()
            .status(httpStatus.getReasonPhrase())
            .massage(massage)
            .data(data)
            .build();
    return ResponseEntity.status(httpStatus).body(response);
    }
}
