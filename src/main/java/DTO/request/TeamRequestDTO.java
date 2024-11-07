package DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamRequestDTO {
    private long id;
    private String city;
    private String franchiseName;
    private String conference;
    private String division;
}
