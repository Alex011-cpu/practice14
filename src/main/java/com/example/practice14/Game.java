package com.example.practice14;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class Game {
    String name;
    LocalDate creationDate;

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
