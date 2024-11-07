package DTO.request;

import entity.TeamEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerRequestDTO {
    private long id;
    private String name;
    private String country;
    private int number;
    private String position;
    private TeamEntity team;
    private int numberOfPick;
}
