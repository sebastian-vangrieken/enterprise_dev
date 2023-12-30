package fact.it.clubservice.repository;

import fact.it.clubservice.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClubRepository extends JpaRepository<Club, Long> {
    List<Club> findClubsByIdIn(List<Long> id);
}
