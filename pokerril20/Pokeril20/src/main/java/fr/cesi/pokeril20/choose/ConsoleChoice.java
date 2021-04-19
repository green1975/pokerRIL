package fr.cesi.pokeril20.choose;

import java.util.List;
import java.util.Scanner;

/**
 * @author Adrien HAUTOT (adrien.hautot@erudo.fr)
 */
public class ConsoleChoice implements Choice{

    @Override
    public <T extends Descriptible> T choose(List<T> possibleChoices) {
        Scanner sc = new Scanner(System.in);
        int saisie = -1;
        do {
            for (int i = 0; i < possibleChoices.size(); i++) {
                System.out.println(i + " : " + possibleChoices.get(i).describe());
            }

            saisie = sc.nextInt();
            if (saisie < 0 || saisie >= possibleChoices.size()) {
                System.out.println("Saisie incorrecte");
            }
            sc.nextLine();
        } while (saisie < 0 || saisie >= possibleChoices.size());

        return possibleChoices.get(saisie);
    }

    @Override
    public <T extends Descriptible> T choose(List<T> possibleChoices, String text) {
        System.out.println("Quelle action souhaitez vous choisir?");
        return choose(possibleChoices);
    }
}
