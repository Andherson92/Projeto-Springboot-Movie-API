package one.digitalinnovation.movieapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String movieName;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String producerName;

    @NotEmpty
    private String durationTime;

    private String releaseDate;

    @Valid
    @NotEmpty
    private List<CategoryDTO> category;
}
