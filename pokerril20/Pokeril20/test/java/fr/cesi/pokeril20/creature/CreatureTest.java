package fr.cesi.pokeril20.creature;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.cesi.pokeril20.skill.ArmorReduction;
import fr.cesi.pokeril20.skill.DamageBoost;
import fr.cesi.pokeril20.skill.DamageReduction;
import fr.cesi.pokeril20.skill.Heal;

public class CreatureTest {
	protected Creature creature1;
	protected Creature creature2;
	protected Heal soin;
	protected DamageReduction dommage;
	protected DamageBoost boost;
	protected ArmorReduction armor;
	
	@Before
	public void setUp() throws Exception {
		creature1 = new Cat ();
		creature2 = new Dragon ();
		soin = new Heal ("pansement", 20);	
		dommage = new DamageReduction("bouclier", 30);
		boost = new DamageBoost("fusil", 50);
		armor = new ArmorReduction("bouclier", 20);
		
	}

	@Test
	public void testAttack () throws Exception {
		creature1.attack(creature2);
		assertEquals(79, creature2.getLifePoints());
	}
	@Test
	public void executeTest() throws Exception {
		soin.execute(creature2, creature1);
		assertEquals(creature2.getLifePoints(), 120);
	}
	@Test
	public void aliveDragonTest() throws Exception {
		creature2.setLifePoints(0);
		assertFalse(creature2.isAlive());
	}
	@Test
	public void surviveCatTest() throws Exception {
		creature1.setLifePoints(0);
		assertTrue(creature1.isAlive());
	}
	@Test
	public void damageTest() throws Exception {
		dommage.execute(creature2, creature1);
		assertEquals(creature1.getLifePoints(), 40);
	}
	@Test
	public void damageBoosTest() throws Exception {
		boost.execute(creature2, creature1);
		assertEquals(creature2.getDamage(), 100);
	}
	@Test
	public void armorReductionTest() throws Exception {
		armor.execute(creature2, creature1);
		assertEquals(creature1.getArmor(), -15);
	}
	@Test
	public void ArmorPositiveTest() {
		armor.execute(creature2, creature1);
		assertTrue(creature1.getArmor() >= 0);
		
	}
}
