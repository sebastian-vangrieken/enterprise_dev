package fact.it.playerservice.repository;

import fact.it.playerservice.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findPlayersByIdIn(List<Long> id);
}
