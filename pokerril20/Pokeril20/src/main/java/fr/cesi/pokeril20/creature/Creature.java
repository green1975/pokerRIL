package fr.cesi.pokeril20.creature;

import fr.cesi.pokeril20.choose.Descriptible;
import fr.cesi.pokeril20.skill.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe permettant de modéliser une créature.
 * - Quels sont les états qu'elle peut avoir
 * - Quelles sont les actions qu'elle peut effectuer
 *
 * @author Adrien HAUTOT (adrien.hautot@erudo.fr)
 */
public abstract class Creature implements Comparable<Creature>, Descriptible {

    /**
     * Contiendra le nom de la créature
     */
    protected String name;
    protected int lifePoints = 0;
    private int damage = 0;
    private int armor = 0;

    protected List<Skill> skills = new ArrayList<>();

    /**
     * Constructeur de créature,  permet d'instancier une créature avec un nom et des points de vie au miminmu
     *
     * @param name       le nom de la créature
     * @param lifePoints les points de vie de la créature
     */
    public Creature(String name, int lifePoints) {
        this.name = name;
        this.lifePoints = lifePoints;
    }

    /**
     * Retourne une description de l'objet actuel
     *
     * @return la description.
     */
    @Override
    public String describe() {
        return name + "(" + lifePoints + " pv)";
    }

    /**
     * Attaque la créature passée en paramètre
     *
     * @param defender la créature qui va s'en prendre plein la tronche
     */
    public void attack(Creature defender) {
        if (defender != null) {
            System.out.println(name + " tente d'infliger " + damage + " à " + defender.getName());
            defender.sufferDamage(this.damage);
        }
    }

    /**
     * Une créature ennemie attaque votre créature et tente de lui infliger expectedDamage de dégat
     *
     * @param expectedDamage les dégats qu'on essaie d'infliger.
     */
    public void sufferDamage(int expectedDamage) {
        if(expectedDamage < this.armor) {
            System.out.println("Invulnérabilité");
        } else {
            this.lifePoints = this.lifePoints - expectedDamage + this.armor;
            if (this.lifePoints < 0) {
                this.lifePoints = 0;
            }
        }
        System.out.println(name + " n'a plus que " + this.lifePoints + "PV");
    }

    public void executeSkill(Skill skill, Creature enemy) {
        System.out.println(name + " utilise " + skill.getName());
        skill.execute(this, enemy);
    }

    /**
     * Permet de savoir si la créature est en vie.
     *
     * @return true si vivante, false si morte
     */
    public abstract boolean isAlive();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    /**
     * Récupère la valeur du champ skills.
     *
     * @return skills.
     */
    public List<Skill> getSkills() {
        return skills;
    }

    /**
     * Défini la nouvelle valeur de skills.
     *
     * @param skills La nouvelle valeur.
     * @return L'instance (Pattern fluent)
     */
    public Creature setSkills(List<Skill> skills) {
        this.skills = skills;
        return this;
    }

    @Override
    public int compareTo(Creature creature) {
        int compare = 0;

        if(getDamage() > creature.getDamage()) {
            compare = 1;
        } else  if(getDamage() < creature.getDamage()) {
            compare = -1;
        }

        return compare;
    }

    @Override
    public String toString() {
        return "fr.cesi.pokeril20.creature.Creature{" +
                "name='" + name + '\'' +
                ", lifePoints=" + lifePoints +
                ", damage=" + damage +
                ", armor=" + armor +
                '}';
    }
}
