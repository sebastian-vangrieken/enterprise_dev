package fact.it.playerservice;

import fact.it.playerservice.dto.PlayerRequest;
import fact.it.playerservice.dto.PlayerResponse;
import fact.it.playerservice.model.Player;
import fact.it.playerservice.repository.PlayerRepository;
import fact.it.playerservice.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlayerServiceApplicationTests {
    @InjectMocks
    private PlayerService playerService;

    @Mock
    private PlayerRepository playerRepository;

    @Test
    public void testCreatePlayer() {
        PlayerRequest playerRequest = new PlayerRequest();
        playerRequest.setFirstName("Test first name");
        playerRequest.setLastName("Test last name");
        playerRequest.setEmail("Test email");
        playerRequest.setAge(20);

        playerService.createPlayer(playerRequest);

        verify(playerRepository, times(1)).save(any(Player.class));
    }

    @Test
    public void testGetAllPlayers() {
        Player player = new Player();
        player.setId(1L);
        player.setFirstName("Test first name");
        player.setLastName("Test last name");
        player.setEmail("Test email");
        player.setAge(20);

        when(playerRepository.findAll()).thenReturn(Arrays.asList(player));

        List<PlayerResponse> players =  playerService.getAllPlayers();

        assertEquals(1, players.size());
        assertEquals("Test first name", players.get(0).getFirstName());
        assertEquals("Test last name", players.get(0).getLastName());
        assertEquals("Test email", players.get(0).getEmail());
        assertEquals(20, players.get(0).getAge());

        verify(playerRepository, times(1)).findAll();
    }
}
