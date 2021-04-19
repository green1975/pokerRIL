package fr.cesi.pokeril20.player;

import fr.cesi.pokeril20.choose.ConsoleChoice;
import fr.cesi.pokeril20.creature.CreatureFactory;
import fr.cesi.pokeril20.creature.CreaturePower;
import fr.cesi.pokeril20.creature.CreatureType;

/**
 * @author Adrien HAUTOT (adrien.hautot@erudo.fr)
 */
public class HumanPlayer extends Player {

    private static HumanPlayer player;

    private HumanPlayer() {
        creatures.add(CreatureFactory.create(CreatureType.REPTILE, CreaturePower.LOW));
        creatures.add(CreatureFactory.create(CreatureType.FELINE, CreaturePower.HIGH));

        choiceSystem = new ConsoleChoice();
    }

    public static HumanPlayer getInstance() {
        if (player == null) {
            player = new HumanPlayer();
        }

        return player;
    }


    @Override
    public String toString() {
        return "HumanPlayer{" +
                "name='" + name + '\'' +
                ", creatures=" + creatures +
                '}';
    }
}
