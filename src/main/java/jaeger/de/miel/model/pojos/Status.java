package jaeger.de.miel.model.pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class Status {
    @NotNull
    private StatusCode code;
    @NotNull
    private String message;
}

