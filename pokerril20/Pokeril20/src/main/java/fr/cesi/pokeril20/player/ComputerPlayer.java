package fr.cesi.pokeril20.player;

import fr.cesi.pokeril20.choose.RandomChoice;
import fr.cesi.pokeril20.creature.CreatureFactory;
import fr.cesi.pokeril20.creature.CreaturePower;
import fr.cesi.pokeril20.creature.CreatureType;

/**
 * @author Adrien HAUTOT (adrien.hautot@erudo.fr)
 */
public class ComputerPlayer extends Player {

    private static ComputerPlayer player;

    private ComputerPlayer() {
        creatures.add(CreatureFactory.create(CreatureType.REPTILE, CreaturePower.LOW));
        creatures.add(CreatureFactory.create(CreatureType.FELINE, CreaturePower.HIGH));

        choiceSystem = new RandomChoice();
    }

    public static ComputerPlayer getInstance() {
        if (player == null) {
            player = new ComputerPlayer();
        }

        return player;
    }

    @Override
    public String toString() {
        return "ComputerPlayer{" +
                "name='" + name + '\'' +
                ", creatures=" + creatures +
                '}';
    }

}
