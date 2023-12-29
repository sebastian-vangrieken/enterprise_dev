package fact.it.clubservice.controller;

import fact.it.clubservice.dto.ClubRequest;
import fact.it.clubservice.dto.ClubResponse;
import fact.it.clubservice.service.ClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/club")
@RequiredArgsConstructor
public class ClubController {
    private final ClubService clubService;

    @GetMapping("/get/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ClubResponse> getAllPlayers() {
        return clubService.getAllClubs();
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<ClubResponse> getAllClubsById
            (@PathVariable List<Long> id) {
        return clubService.getAllClubsById(id);
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.OK)
    public void createClub
            (@RequestBody ClubRequest clubRequest) {
        clubService.createClub(clubRequest);
    }

    @PutMapping("/put/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateClub
            (@PathVariable Long id, @RequestBody ClubRequest updateClub) {
        clubService.updateClub(id, updateClub);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClubById
            (@PathVariable List<Long> id) {
        clubService.deleteClubsById(id);
    }
}
