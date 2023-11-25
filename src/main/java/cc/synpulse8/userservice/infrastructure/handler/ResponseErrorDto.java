package cc.synpulse8.userservice.infrastructure.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseErrorDto {

    private HttpStatus httpStatus;

    private String customErrorCode;

    private String errMessage;

}
