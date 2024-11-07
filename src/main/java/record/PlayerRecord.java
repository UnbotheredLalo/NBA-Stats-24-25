package record;

import entity.TeamEntity;

public record PlayerRecord(Long id,
                           String name,
                           int number,
                           String country,
                           String position,
                           TeamEntity team) {}
