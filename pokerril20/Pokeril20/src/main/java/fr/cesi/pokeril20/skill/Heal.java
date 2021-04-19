package fr.cesi.pokeril20.skill;

import fr.cesi.pokeril20.creature.Creature;

/**
 * Représente une compétence de soin.
 * @author Adrien HAUTOT (adrien.hautot@erudo.fr)
 */
public class Heal extends Skill {

    public Heal(String name, int value) {
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
        if(executor != null) {
            executor.setLifePoints(executor.getLifePoints() + value);
        }
    }
}
