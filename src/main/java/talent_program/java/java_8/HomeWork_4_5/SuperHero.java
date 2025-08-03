package main.java.talent_program.java.java_8.HomeWork_4_5;

import java.util.Objects;

public abstract class SuperHero {
    private String heroName;
    private int powerLevel;
    private double powerBoostTime;
    private int powerBoostAmount;

    abstract void usePower();

    void powerBoost(double powerBoostTime, int powerBoostAmount) {
        int originalPower = getPowerLevel();

        setPowerLevel(originalPower + powerBoostAmount);
        System.out.printf("%s is boosted power to %s for %s seconds%n", getHeroName(), getPowerLevel(), powerBoostTime);
        if(Objects.equals(getHeroName(), "Super Man")) {
            System.out.println("With a burst of energy, he rockets into the sky!");
        } else if (Objects.equals(getHeroName(), "Hulk")) {
            System.out.println("With a grunt, he hurls the boulder across the battlefield!");
        } else if (Objects.equals(getHeroName(), "Flash")) {
            System.out.printf("Time seems to slow around him — but %s's only getting faster!%n", getHeroName());
        }

        new Thread(() -> {
            try {
                Thread.sleep((long) (powerBoostTime * 1000));
            } catch (InterruptedException e){
                e.printStackTrace();
            }

            setPowerLevel(originalPower);
            System.out.println(" ");
            System.out.printf("%s is restored power to %s%n", getHeroName(), getPowerLevel());
        }).start();
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }
}
