package br.com.devnaldo.api_heros.repositories;

import br.com.devnaldo.api_heros.models.Heroes;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableScan
public interface HerosRepository extends CrudRepository<Heroes, String> {
}
