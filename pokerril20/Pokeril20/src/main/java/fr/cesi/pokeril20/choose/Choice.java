package fr.cesi.pokeril20.choose;

import java.util.List;

/**
 * @author Adrien HAUTOT (adrien.hautot@erudo.fr)
 */
public interface Choice {

    <T extends Descriptible> T choose(List<T> possibleChoices);

    <T extends Descriptible> T choose(List<T> possibleChoices, String text);

}
