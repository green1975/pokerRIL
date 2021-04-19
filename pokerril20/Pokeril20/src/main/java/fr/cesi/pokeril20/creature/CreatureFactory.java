package fr.cesi.pokeril20.creature;

/**
 * @author Adrien HAUTOT (adrien.hautot@erudo.fr)
 */
public class CreatureFactory {

    public static Creature create(CreatureType type, CreaturePower power) {
        System.out.println("Création d'une créature " + type + " / " + power);
        Creature creature;

        switch (type) {
            case FELINE:
                creature = new Cat();
                break;
            case REPTILE:
                creature = new Dragon();
                break;
            default:
                creature = new Cat();
        }

        switch (power) {
            case LOW:
                creature.setDamage(creature.getDamage() / 2);
                creature.setArmor(creature.getArmor() / 2);
                creature.setLifePoints(creature.getLifePoints() / 2);
                break;
            case HIGH:
                creature.setDamage(creature.getDamage() * 2);
                creature.setArmor(creature.getArmor() * 2);
                creature.setLifePoints(creature.getLifePoints() * 2);
                break;
        }


        return creature;
    }
}
