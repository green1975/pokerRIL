package fr.cesi.pokeril20.creature;

import fr.cesi.pokeril20.skill.Damage;
import fr.cesi.pokeril20.skill.Heal;

/**
 * @author Adrien HAUTOT (adrien.hautot@erudo.fr)
 */
public class Cat extends Creature {

    private int lifeCount = 9;
    private int initialLifePoints = 0;

    /**
     * Constructeur de créature,  permet d'instancier une créature avec un nom et des points de vie au miminmu
     */
    public Cat() {
        super("Garfield", 40);
        this.setArmor(5);
        this.setDamage(31);
        initialLifePoints = this.lifePoints;

        this.skills.add(new Damage("Coup de griffe", 50));
        this.skills.add(new Heal("Soin divin", 50));
    }

    /**
     * Permet de savoir si la créature est en vie.
     *
     * @return true si vivante, false si morte
     */
    @Override
    public boolean isAlive() {
        if(this.lifePoints <= 0) {
            this.lifeCount--;
            if(this.lifeCount > 0) {
                System.out.println("Le chat réssuscite");
                this.lifePoints = this.initialLifePoints;
            }
        }
        return this.lifePoints > 0;
    }

}
