package fr.cesi.pokeril20.skill;

import fr.cesi.pokeril20.creature.Creature;

/**
 * Représente une compétence de dégâts.
 *
 * @author Adrien HAUTOT (adrien.hautot@erudo.fr)
 */
public class Damage extends Skill {

    public Damage(String name, int value) {
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
        enemy.setLifePoints(executor.getLifePoints() - value);
    }
}
