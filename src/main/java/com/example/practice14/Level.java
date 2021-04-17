package com.example.practice14;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class Level {
    String complexity;
    String levelName;

    @Override
    public String toString() {
        return "Level{" +
                "complexity='" + complexity + '\'' +
                ", levelName='" + levelName + '\'' +
                '}';
    }
}
