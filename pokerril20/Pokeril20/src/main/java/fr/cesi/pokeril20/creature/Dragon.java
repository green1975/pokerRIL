package fr.cesi.pokeril20.creature;

import fr.cesi.pokeril20.skill.ArmorBoost;
import fr.cesi.pokeril20.skill.Damage;

/**
 * @author Adrien HAUTOT (adrien.hautot@erudo.fr)
 */
public class Dragon extends Creature {

    /**
     * Constructeur de créature,  permet d'instancier une créature avec un nom et des points de vie au miminmu
     */
    public Dragon() {
        super("Smaug", 100);
        this.setArmor(10);
        this.setDamage(50);

        this.skills.add(new Damage("Boule de feu", 100));
        this.skills.add(new ArmorBoost("Ecaille dure", 5));
    }

    /**
     * Permet de savoir si la créature est en vie.
     *
     * @return true si vivante, false si morte
     */
    @Override
    public boolean isAlive() {
        return this.lifePoints > 0;
    }
}

