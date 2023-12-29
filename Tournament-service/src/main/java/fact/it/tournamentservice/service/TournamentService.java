package fact.it.tournamentservice.service;

import fact.it.tournamentservice.dto.TournamentRequest;
import fact.it.tournamentservice.dto.TournamentResponse;
import fact.it.tournamentservice.model.Tournament;
import fact.it.tournamentservice.repository.TournamentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TournamentService {
    private final TournamentRepository tournamentRepository;

    public List<TournamentResponse> getAllTournaments() {
        List<Tournament> tournaments = tournamentRepository.findAll();
        return tournaments.stream()
                .map(this::mapToTournamentResponse)
                .collect(Collectors.toList());
    }

    public List<TournamentResponse> getAllTournamentsById(List<String> id) {
        List<Tournament> tournaments = tournamentRepository.findTournamentByIdIn(id);
        return tournaments.stream().map(this::mapToTournamentResponse).toList();
    }

    public void createTournament(TournamentRequest tournamentRequest) {
        Tournament tournament = Tournament.builder()
                .name(tournamentRequest.getName())
                .startDate(tournamentRequest.getStartDate())
                .endDate(tournamentRequest.getEndDate())
                .build();
        tournamentRepository.save(tournament);
        System.out.println(tournament);
    }

    public void updateTournament(String id, TournamentRequest updatedTournament) {
        Optional<Tournament> optionalTournament = tournamentRepository.findById(id);
        if (optionalTournament.isPresent()) {
            Tournament tournament = optionalTournament.get();
            tournament.setName(updatedTournament.getName());
            tournament.setStartDate(updatedTournament.getStartDate());
            tournament.setEndDate(updatedTournament.getEndDate());
            tournamentRepository.save(tournament);
        }
    }

    public void deleteTournamentsById(List<String> id) {
        tournamentRepository.deleteAllById(id);
    }

    private TournamentResponse mapToTournamentResponse(Tournament tournament) {
        return TournamentResponse.builder()
                .id(tournament.getId())
                .name(tournament.getName())
                .startDate(tournament.getStartDate())
                .endDate(tournament.getEndDate())
                .build();
    }
}
