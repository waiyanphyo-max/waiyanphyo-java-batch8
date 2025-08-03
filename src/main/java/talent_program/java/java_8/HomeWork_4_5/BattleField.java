package main.java.talent_program.java.java_8.HomeWork_4_5;

import java.util.ArrayList;

public class BattleField {
    public static void main(String[] args) {
        final var arrayList = getSuperHeroes();

        SuperHero[] superHeroes = arrayList.toArray(new SuperHero[0]);


        System.out.println("From every corner of the world, they arrive — speedsters, flyers, titans of strength.");
        for (SuperHero superHero : superHeroes) {
            System.out.println(" ");
            System.out.println(superHero.getHeroName());
            superHero.usePower();

            superHero.powerBoost(3.0, 10);
        }
    }

    private static ArrayList<SuperHero> getSuperHeroes() {
        FlyingHero superMan = new FlyingHero();
        superMan.setHeroName("Super Man");
        superMan.setPowerLevel(86);

        SpeedHero flash = new SpeedHero();
        flash.setHeroName("Flash");
        flash.setPowerLevel(79);

        StrengthHero hulk = new StrengthHero();
        hulk.setHeroName("Hulk");
        hulk.setPowerLevel(76);

        ArrayList<SuperHero> superHeroes= new ArrayList<>();
        superHeroes.add(superMan);
        superHeroes.add(flash);
        superHeroes.add(hulk);

        return superHeroes;
    }
}
