package fact.it.clubservice;

import fact.it.clubservice.dto.ClubRequest;
import fact.it.clubservice.dto.ClubResponse;
import fact.it.clubservice.model.Club;
import fact.it.clubservice.repository.ClubRepository;
import fact.it.clubservice.service.ClubService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClubServiceApplicationTests {

    @InjectMocks
    private ClubService clubService;

    @Mock
    private ClubRepository clubRepository;

    @Test
    public void testCreateTournament() {
        ClubRequest clubRequest = new ClubRequest();
        clubRequest.setName("Test club");
        clubRequest.setStreet("Test street");
        clubRequest.setStreetNbr(13);

        clubService.createClub(clubRequest);

        verify(clubRepository, times(1)).save(any(Club.class));
    }

    @Test
    public void testGetAllClubs() {
        Club club = new Club();
        club.setId(1L);
        club.setName("Test club");
        club.setStreet("Test street");
        club.setStreetNbr(13);

        when(clubRepository.findAll()).thenReturn(Arrays.asList(club));

        List<ClubResponse> clubs = clubService.getAllClubs();

        assertEquals(1, clubs.size());
        assertEquals("Test club", clubs.get(0).getName());
        assertEquals("Test street", clubs.get(0).getStreet());
        assertEquals(13, clubs.get(0).getStreetNbr());

        verify(clubRepository, times(1)).findAll();
    }

}