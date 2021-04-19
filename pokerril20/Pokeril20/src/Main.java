import fr.cesi.pokeril20.action.Action;
import fr.cesi.pokeril20.choose.RandomChoice;
import fr.cesi.pokeril20.creature.Creature;
import fr.cesi.pokeril20.player.ComputerPlayer;
import fr.cesi.pokeril20.player.HumanPlayer;
import fr.cesi.pokeril20.player.Player;
import fr.cesi.pokeril20.skill.Skill;

import java.util.Arrays;

/**
 * @author Adrien HAUTOT (adrien.hautot@erudo.fr)
 */
public class Main {


    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    public void start() {
        Player player1 = HumanPlayer.getInstance();
        Player player2 = ComputerPlayer.getInstance();

        Creature creaturePlayer1 = player1.getChoiceSystem()
                .choose(player1.getCreatures(), "Quelle créature souhaitez vous choisir?");
        Creature creaturePlayer2 = player2.getChoiceSystem()
                .choose(player1.getCreatures(), "Quelle créature souhaitez vous choisir?");

        do {
            turn(player1, creaturePlayer1, creaturePlayer2);
            turn(player2, creaturePlayer2, creaturePlayer1);
        } while (creaturePlayer2.isAlive() && creaturePlayer1.isAlive());
    }

    /**
     * Le tour d'un joueur
     * @param player le joueur a qui c'est le tour
     * @param playerCreature la créature du joueur
     * @param enemyCreature la créature ennemy du joueur
     */
    private void turn(Player player, Creature playerCreature, Creature enemyCreature) {
        Action action = player.getChoiceSystem()
                .choose(Arrays.asList(Action.values()), "Quelle action souhaitez vous choisir?");
        switch (action) {
            case ATTACK:
                playerCreature.attack(enemyCreature);
                break;
            case CHOOSE_SKILL:
                Skill skill1 = player.getChoiceSystem()
                        .choose(playerCreature.getSkills(), "Quelle compétence souhaitez vous choisir?");
                playerCreature.executeSkill(skill1, enemyCreature);
                break;
        }
    }
}
