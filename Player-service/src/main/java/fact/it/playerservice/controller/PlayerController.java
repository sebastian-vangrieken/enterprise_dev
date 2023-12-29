package fact.it.playerservice.controller;

import fact.it.playerservice.dto.PlayerRequest;
import fact.it.playerservice.dto.PlayerResponse;
import fact.it.playerservice.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/player")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;

    @GetMapping("/get/all")
    @ResponseStatus(HttpStatus.OK)
    public List<PlayerResponse> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<PlayerResponse> getAllPlayersById
            (@PathVariable List<Long> id) {
        return playerService.getAllPlayersById(id);
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.OK)
    public void createPlayer
            (@RequestBody PlayerRequest playerRequest) {
        playerService.createPlayer(playerRequest);
    }

    @PutMapping("/put/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePlayer
            (@PathVariable Long id, @RequestBody PlayerRequest updatePlayer) {
        playerService.updatePlayer(id, updatePlayer);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePlayersById
            (@PathVariable List<Long> id) {
        playerService.deletePlayersById(id);
    }
}
