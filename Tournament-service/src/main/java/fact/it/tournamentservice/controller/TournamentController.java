package fact.it.tournamentservice.controller;

import fact.it.tournamentservice.dto.TournamentRequest;
import fact.it.tournamentservice.dto.TournamentResponse;
import fact.it.tournamentservice.service.TournamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tournament")
@RequiredArgsConstructor
public class TournamentController {
    private final TournamentService tournamentService;

    @GetMapping("/get/all")
    @ResponseStatus(HttpStatus.OK)
    public List<TournamentResponse> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<TournamentResponse> getAllTournamentsById(@PathVariable List<String> id) {
        return tournamentService.getAllTournamentsById(id);
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.OK)
    public void createTournament(@RequestBody TournamentRequest tournamentRequest) {
        tournamentService.createTournament(tournamentRequest);
    }

    @PutMapping("/put/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateTournament(@PathVariable String id, @RequestBody TournamentRequest updateTournament) {
        tournamentService.updateTournament(id, updateTournament);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTournamentsById(@PathVariable List<String> id) {
        tournamentService.deleteTournamentsById(id);
    }
}