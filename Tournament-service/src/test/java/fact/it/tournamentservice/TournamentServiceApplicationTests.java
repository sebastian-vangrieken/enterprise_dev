package fact.it.tournamentservice;

import fact.it.tournamentservice.dto.TournamentRequest;
import fact.it.tournamentservice.dto.TournamentResponse;
import fact.it.tournamentservice.model.Tournament;
import fact.it.tournamentservice.repository.TournamentRepository;
import fact.it.tournamentservice.service.TournamentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TournamentServiceApplicationTests {
    @InjectMocks
    private TournamentService tournamentService;

    @Mock
    private TournamentRepository tournamentRepository;

    @Test
    public void testCreateTournament() {
        TournamentRequest tournamentRequest = new TournamentRequest();
        tournamentRequest.setName("Test tournament");
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.set(2024, 1, 6);
        Date setStartDate = startCalendar.getTime();
        tournamentRequest.setStartDate(setStartDate);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.set(2024, 1, 12);
        Date setEndDate = endCalendar.getTime();
        tournamentRequest.setEndDate(setEndDate);

        tournamentService.createTournament(tournamentRequest);

        verify(tournamentRepository, times(1)).save(any(Tournament.class));
    }

    @Test
    public void testGetAllTournaments() {
        Tournament tournament = new Tournament();
        tournament.setId("1");
        tournament.setName("Test tournament");
        Calendar setStartCalendar = Calendar.getInstance();
        setStartCalendar.set(2024, 1, 6);
        Date setStartDate = setStartCalendar.getTime();
        tournament.setStartDate(setStartDate);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.set(2024, 1, 12);
        Date setEndDate = endCalendar.getTime();
        tournament.setEndDate(setEndDate);

        when(tournamentRepository.findAll()).thenReturn(Arrays.asList(tournament));

        List<TournamentResponse> tournaments = tournamentService.getAllTournaments();

        assertEquals(1, tournaments.size());
        assertEquals("Test tournament", tournaments.get(0).getName());
        Calendar getStartCalender = Calendar.getInstance();
        getStartCalender.set(2024, 1, 6);
        Date getStartDate = getStartCalender.getTime();
        assertEquals(getStartDate, tournaments.get(0).getStartDate());
        Calendar getEndCalender = Calendar.getInstance();
        getEndCalender.set(2024, 1, 12);
        Date getEndDate = getEndCalender.getTime();
        assertEquals(getEndDate, tournaments.get(0).getEndDate());

        verify(tournamentRepository, times(1)).findAll();
    }
}
