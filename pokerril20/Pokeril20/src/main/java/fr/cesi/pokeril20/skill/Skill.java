package fr.cesi.pokeril20.skill;


import fr.cesi.pokeril20.choose.Descriptible;
import fr.cesi.pokeril20.creature.Creature;

/**
 * Classe représentant une compétence.
 * @author Adrien HAUTOT (adrien.hautot@erudo.fr)
 */
public abstract class Skill implements Descriptible {

    protected String name;

    protected int value;

    public Skill(String name, int value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Permet de lancer la compétence
     * @param executor la créature qui execute la compétence
     * @param enemy la créature ennemie à la créature qui lance la compétence
     */
    public abstract void execute(Creature executor, Creature enemy);

    /**
     * Retourne une description de l'objet actuel
     *
     * @return la description.
     */
    @Override
    public String describe() {
        return name + "(" + value + " pts)";
    }

    /**
     * Récupère la valeur du champ name.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Défini la nouvelle valeur de name.
     *
     * @param name La nouvelle valeur.
     * @return L'instance (Pattern fluent)
     */
    public Skill setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Récupère la valeur du champ value.
     *
     * @return value.
     */
    public int getValue() {
        return value;
    }

    /**
     * Défini la nouvelle valeur de value.
     *
     * @param value La nouvelle valeur.
     * @return L'instance (Pattern fluent)
     */
    public Skill setValue(int value) {
        this.value = value;
        return this;
    }
}
