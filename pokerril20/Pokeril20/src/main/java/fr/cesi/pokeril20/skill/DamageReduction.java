package fr.cesi.pokeril20.skill;

import fr.cesi.pokeril20.creature.Creature;

/**
 * Représente une compétence de soin.
 * @author Adrien HAUTOT (adrien.hautot@erudo.fr)
 */
public class DamageReduction extends Skill {

    public DamageReduction(String name, int value) {
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
        enemy.setDamage(enemy.getDamage() - value);
    }
}
