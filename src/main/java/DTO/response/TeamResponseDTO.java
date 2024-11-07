package DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamResponseDTO {
    private String city;
    private String franchiseName;
    private String conference;
    private String division;
    private int championships;
    private int conferenceChamps;
}
