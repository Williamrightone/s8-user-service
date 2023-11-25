package cc.synpulse8.userservice.presentation.rest;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RestfulResponse <T> implements Serializable {

    private static final long serialVersionUID = -6022453015589774883L;

    private T data;

    public RestfulResponse(T data) {
        this.data = data;
    }

}
