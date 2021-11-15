package kg.it_academy.sell_soul.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage <T>{
    private T value;
    private String message;
    private String status;

    public ResponseMessage<T> prepareSuccessMessage(T value){
        return ResponseMessage.<T>builder()
                .value(value)
                .message(null)
                .status("OK")
                .build();
    }
    public ResponseMessage<T> prepareFailMessage(String message){
        return ResponseMessage.<T>builder()
                .value(null)
                .message(message)
                .status("FAIL")
                .build();
    }
    public ResponseMessage<T> prepareErrorMessage(String message){
        return ResponseMessage.<T>builder()
                .value(null)
                .message(message)
                .status("ERROR")
                .build();
    }
}

