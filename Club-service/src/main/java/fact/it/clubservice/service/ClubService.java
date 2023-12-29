package fact.it.clubservice.service;

import fact.it.clubservice.dto.ClubRequest;
import fact.it.clubservice.dto.ClubResponse;
import fact.it.clubservice.model.Club;
import fact.it.clubservice.repository.ClubRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ClubService {
    private final ClubRepository clubRepository;

    public List<ClubResponse> getAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream()
                .map(this::mapToClubResponse)
                .collect(Collectors.toList());
    }

    public List<ClubResponse> getAllClubsById(List<Long> id) {
        List<Club> clubs = clubRepository.findClubsByIdIn(id);
        return clubs.stream().map(this::mapToClubResponse).toList();
    }

    public void createClub(ClubRequest clubRequest) {
        Club club = Club.builder()
                .name(clubRequest.getName())
                .street(clubRequest.getStreet())
                .streetNbr(clubRequest.getStreetNbr())
                .build();
        clubRepository.save(club);
    }

    public void updateClub(Long id, ClubRequest updateClub) {
        Optional<Club> optionalClub = clubRepository.findById(id);
        if (optionalClub.isPresent()) {
            Club club = optionalClub.get();
            club.setName(updateClub.getName());
            club.setStreet(updateClub.getStreet());
            club.setStreetNbr(updateClub.getStreetNbr());
            clubRepository.save(club);
        }
    }

    public void deleteClubsById(List<Long> id) {
        clubRepository.deleteAllById(id);
    }

    private ClubResponse mapToClubResponse(Club club) {
        return ClubResponse.builder()
                .id(club.getId())
                .name(club.getName())
                .street(club.getStreet())
                .streetNbr(club.getStreetNbr())
                .build();
    }
}
