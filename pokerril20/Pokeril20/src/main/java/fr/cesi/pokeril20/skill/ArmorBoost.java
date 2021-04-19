package fr.cesi.pokeril20.skill;


import fr.cesi.pokeril20.creature.Creature;

import java.util.Collections;

/**
 * Représente une compétence de soin.
 * @author Adrien HAUTOT (adrien.hautot@erudo.fr)
 */
public class ArmorBoost extends Skill {

    public ArmorBoost(String name, int value) {
        super(name, value);
    }

    /**
     * Permet de lancer la compétence
     *
     * @param executor la créature qui execute la compétence
     * @param enemy    la créature ennemie à la créature qui lance la compétence
     */
    @Override
    public void execute(Creature executor, Creature enemy) {
        executor.setArmor(executor.getArmor() + value);
    }
}
