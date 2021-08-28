package one.digitalinnovation.movieapi.mapper;

import one.digitalinnovation.movieapi.dto.request.MovieDTO;
import one.digitalinnovation.movieapi.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper {

    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    @Mapping(target = "releaseDate", source = "releaseDate", dateFormat = "dd-MM-yyyy")
    Movie toModel(MovieDTO movieDTO);

    MovieDTO toDTO(Movie person);
}
