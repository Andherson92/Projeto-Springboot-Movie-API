package one.digitalinnovation.movieapi.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.movieapi.dto.request.MovieDTO;
import one.digitalinnovation.movieapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.movieapi.exception.MovieNotFoundException;
import one.digitalinnovation.movieapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MovieController {

    private MovieService movieService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid MovieDTO movieDTO) {
        return movieService.createMovie(movieDTO);
    }

    @GetMapping
    public List<MovieDTO> ListAll() {
        return movieService.listAll();
    }

    @GetMapping("/{id}")
    public MovieDTO findById(@PathVariable Long id) throws MovieNotFoundException {
        return movieService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid MovieDTO movieDTO) throws MovieNotFoundException {
        return movieService.updateById(id, movieDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws MovieNotFoundException {
        movieService.delete(id);
    }
}
