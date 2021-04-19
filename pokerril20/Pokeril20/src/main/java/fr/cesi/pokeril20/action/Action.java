package fr.cesi.pokeril20.action;

import fr.cesi.pokeril20.choose.Descriptible;

/**
 * @author Adrien HAUTOT (adrien.hautot@erudo.fr)
 */
public enum Action implements Descriptible {
    ATTACK("Attaque"),
    CHOOSE_SKILL("Choisir une compétence");

    private String name;

    Action(String name) {
        this.name = name;
    }

    /**
     * Retourne une description de l'objet actuel
     *
     * @return la description.
     */
    @Override
    public String describe() {
        return name;
    }
}
