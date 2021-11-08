package kg.it_academy.sell_soul.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage<T> {
    private T value;

    private Integer status;

    private String details;

    public ResponseMessage<T> prepareSuccessMessage(T value) {
        ResponseMessage<T> successMessage = new ResponseMessage<T>();
        successMessage.setValue(value);
        successMessage.setStatus(HttpStatus.OK.value());
        successMessage.setDetails("");
        return successMessage;
    }
}
