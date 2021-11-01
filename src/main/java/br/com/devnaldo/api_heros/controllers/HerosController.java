package br.com.devnaldo.api_heros.controllers;

import br.com.devnaldo.api_heros.models.Heroes;
import br.com.devnaldo.api_heros.repositories.HerosRepository;
import br.com.devnaldo.api_heros.services.HerosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static br.com.devnaldo.api_heros.contrans.HeroCotrans.HEROES_ENDPOINT_LOCAL;

@RestController
@Slf4j

public class HerosController {

    HerosService herosService;
    HerosRepository herosRepository;


    private static final org.slf4j.Logger log =
            org.slf4j.LoggerFactory.getLogger(HerosController.class);

    public HerosController(HerosService heroesService, HerosRepository heroesRepository) {
        this.herosService = heroesService;
        this.herosRepository = heroesRepository;
    }

    @GetMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Heroes> getAllItems() {
        log.info("requesting the list off all heroes");
        return herosService.findAll();

    }


    @GetMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
    public Mono<ResponseEntity<Heroes>> findByIdHero(@PathVariable String id) {
        log.info("Requesting the hero with id {}", id);
        return herosService.findById(id)
                .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Heroes> createHero(@RequestBody Heroes heroes) {
        log.info("A new Hero was Created");
        return herosService.save(heroes);

    }

    @DeleteMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Mono<HttpStatus> deletebyIDHero(@PathVariable String id) {
        herosService.delete(id);
        log.info("Deleting the hero with id {}", id);
        return Mono.just(HttpStatus.NOT_FOUND);
    }
}
