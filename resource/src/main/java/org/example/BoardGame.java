package org.example;

import jakarta.validation.constraints.Size;

public class BoardGame extends CommonBase  {
    @Size(max = 120, message = "nazwa gry musi mieć maksymalnie 120 znakow")
    private String gameName;
    private int minAge;
    private int maxAge;

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public BoardGame(String gameName, int minAge, int maxAge) {
        this.gameName = gameName;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }
}
