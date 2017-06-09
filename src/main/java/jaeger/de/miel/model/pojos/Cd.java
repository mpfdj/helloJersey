package jaeger.de.miel.model.pojos;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class Cd {
    @NotNull private String title;
    @NotNull private String artist;
    private String genre;
    @JsonIgnore private int catalogId;
}
