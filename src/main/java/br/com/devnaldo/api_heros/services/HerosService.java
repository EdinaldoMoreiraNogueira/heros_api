package br.com.devnaldo.api_heros.services;


import br.com.devnaldo.api_heros.models.Heroes;
import br.com.devnaldo.api_heros.repositories.HerosRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HerosService {

    private final HerosRepository herosRepository;

    public HerosService(HerosRepository herosRepository){
        this.herosRepository=herosRepository;
    }

    public Flux<Heroes> findAll(){
        return Flux.fromIterable(this.herosRepository.findAll());
    }

    public Mono<Heroes> findById(String id){
        return Mono.justOrEmpty(this.herosRepository.findById(id));

    }

    public Mono<Heroes> save(Heroes heroes){
        return Mono.justOrEmpty(this.herosRepository.save(heroes));
    }

    public Mono<Boolean> delete(String id){
        herosRepository.deleteById(id);
        return Mono.justOrEmpty(true);
    }
}
