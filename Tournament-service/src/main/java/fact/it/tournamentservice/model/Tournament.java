package fact.it.tournamentservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(value = "tournament")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Tournament {
    private String id;
    private String name;
    private Date startDate;
    private Date endDate;
}
