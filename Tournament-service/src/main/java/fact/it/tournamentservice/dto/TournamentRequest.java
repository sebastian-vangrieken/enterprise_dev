package fact.it.tournamentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TournamentRequest {
    private String name;
    private Date startDate;
    private Date endDate;
}
