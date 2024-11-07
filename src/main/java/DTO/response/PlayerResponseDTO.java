package DTO.response;

import entity.TeamEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerResponseDTO {
    private String name;
    private String country;
    private TeamEntity team;
    private int number;
    private String position;
    private int numberOfPick;
}
