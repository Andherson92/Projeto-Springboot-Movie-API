package one.digitalinnovation.movieapi.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.movieapi.dto.request.MovieDTO;
import one.digitalinnovation.movieapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.movieapi.entity.Movie;
import one.digitalinnovation.movieapi.exception.MovieNotFoundException;
import one.digitalinnovation.movieapi.mapper.MovieMapper;
import one.digitalinnovation.movieapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MovieService {

    private MovieRepository movieRepository;

    private final MovieMapper movieMapper = MovieMapper.INSTANCE;

    public MessageResponseDTO createMovie(MovieDTO movieDTO) {
        Movie movieToSave = movieMapper.toModel(movieDTO);
        Movie savedMovie = movieRepository.save(movieToSave);
        return createMessageResponse(savedMovie.getId(), "Created movie with ID ");
    }

    public List<MovieDTO> listAll() {
        List<Movie> allMovies = movieRepository.findAll();
        return allMovies.stream()
                .map(movieMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MovieDTO findById(Long id) throws MovieNotFoundException {
        Movie movie = verifyIfExists(id);
        return movieMapper.toDTO(movie);
    }

    public void delete(Long id) throws MovieNotFoundException {
        verifyIfExists(id);
        movieRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, MovieDTO movieDTO) throws MovieNotFoundException {
        verifyIfExists(id);

        Movie movieToUpdate = movieMapper.toModel(movieDTO);
        Movie updatedMovie = movieRepository.save(movieToUpdate);
        return createMessageResponse(updatedMovie.getId(), "Updated movie with ID ");
    }

    private Movie verifyIfExists(Long id) throws MovieNotFoundException {
        return movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
