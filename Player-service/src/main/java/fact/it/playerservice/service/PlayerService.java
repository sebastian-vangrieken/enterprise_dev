package fact.it.playerservice.service;

import fact.it.playerservice.dto.PlayerRequest;
import fact.it.playerservice.dto.PlayerResponse;
import fact.it.playerservice.model.Player;
import fact.it.playerservice.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Value("${clubservice.baseurl}")
    private String clubServiceBaseUrl;
    @Value("${tournamentservice.baseurl}")
    private String tournamentServiceBaseUrl;

    public List<PlayerResponse> getAllPlayers() {
        List<Player> players = playerRepository.findAll();
        return players.stream()
                .map(this::mapToPlayerResponse)
                .collect(Collectors.toList());
    }

    public List<PlayerResponse> getAllPlayersById(List<Long> id) {
        List<Player> players = playerRepository.findPlayersByIdIn(id);
        return players.stream().map(this::mapToPlayerResponse).toList();
    }

    public void createPlayer(PlayerRequest playerRequest) {
        Player player = Player.builder()
                .firstName(playerRequest.getFirstName())
                .lastName(playerRequest.getLastName())
                .email(playerRequest.getEmail())
                .age(playerRequest.getAge())
                .build();
        playerRepository.save(player);
    }

    public void updatePlayer(Long id, PlayerRequest updatedPlayer) {
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        if (optionalPlayer.isPresent()) {
            Player player = optionalPlayer.get();
            player.setFirstName(updatedPlayer.getFirstName());
            player.setLastName(updatedPlayer.getLastName());
            player.setEmail(updatedPlayer.getEmail());
            player.setAge(updatedPlayer.getAge());
            playerRepository.save(player);
        }
    }

    public void deletePlayersById(List<Long> id) {
        playerRepository.deleteAllById(id);
    }

    private PlayerResponse mapToPlayerResponse(Player player) {
        return PlayerResponse.builder()
                .id(player.getId())
                .firstName(player.getFirstName())
                .lastName(player.getLastName())
                .email(player.getEmail())
                .age(player.getAge())
                .build();
    }
}
