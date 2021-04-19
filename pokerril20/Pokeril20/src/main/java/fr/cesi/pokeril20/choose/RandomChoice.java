package fr.cesi.pokeril20.choose;

import java.util.List;
import java.util.Random;

/**
 * @author Adrien HAUTOT (adrien.hautot@erudo.fr)
 */
public class RandomChoice implements Choice {
    @Override
    public <T extends Descriptible> T choose(List<T> possibleChoices) {
        return possibleChoices.get(new Random().nextInt(possibleChoices.size()));
    }

    @Override
    public <T extends Descriptible> T choose(List<T> possibleChoices, String text) {
        return choose(possibleChoices);
    }
}
