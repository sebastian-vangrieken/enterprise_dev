package fact.it.tournamentservice.repository;

import fact.it.tournamentservice.model.Tournament;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TournamentRepository extends MongoRepository<Tournament, String> {
    List<Tournament> findTournamentByIdIn(List<String> id);
}
