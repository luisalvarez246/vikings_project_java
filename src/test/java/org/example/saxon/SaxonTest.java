package org.example.saxon;
import org.example.soldier.Soldier;
import org.example.vikings.Vikings;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;


class SaxonTest
{
    int health = 60;
    int strength = 25;

    Saxon saxon = new Saxon(health, strength, "");

    @Test
    public void should_inherit_from_Soldier()
    {
        assertNotNull(saxon instanceof Soldier);
    }

    @Test
    public void should_receive_2_arguments()
    {
       // Arrange
        Class<Saxon> saxon = Saxon.class;
        Constructor[] saxonCons = saxon.getConstructors();
        // Act
        int params = saxonCons[0].getParameterCount();
        //Assert
        System.out.println(Arrays.toString(saxonCons));
        assertEquals(3, params);
    }

    @Test
    public void should_receive_the_health_property_as_its_1st_argument()
    {
        // Arrange
        Field[] saxonFields = Saxon.class.getFields();
        String  healthParam = saxonFields[0].toString();
        // Act
        System.out.println(Arrays.toString(saxonFields));
        int     firstParamHealth = healthParam.indexOf("health");
        //Assert
        assertTrue(firstParamHealth > 0 );
    }

    @Test
    public void should_receive_the_health_property_as_its_2st_argument()
    {
        // Arrange
        Field[] saxonFields = Saxon.class.getFields();
        String  strengthParam = saxonFields[1].toString();
        // Act
        System.out.println(Arrays.toString(saxonFields));
        int     secondParamHealth = strengthParam.indexOf("strength");
        //Assert
        assertTrue(secondParamHealth > 0 );
    }

    @Test
    public void attack_should_return_strength_property_of_the_Saxon()
    {
        int resultAttack = Saxon.attack();
        assertEquals(Saxon.strength, resultAttack);
    }

    @Test
    public void attack_should_receive_0_arguments()
    {
        //Arrange
        String  attackMethod = Saxon.class.getDeclaredMethods()[0].toString();
        //Act
        int     hasNoArgs = attackMethod.indexOf("attack()");
        System.out.println(Arrays.toString(Saxon.class.getDeclaredMethods()));
        //Assert
        assertTrue(hasNoArgs > 0);
    }

    @Test
    public void receiveDamage_should_receive_1_arguments()
    {
       //arrange
        Class<Saxon> saxon = Saxon.class;
        //act
        int numberArgs = saxon.getDeclaredMethods()[1].getParameterCount();
//        System.out.println(Arrays.toString(saxon.getDeclaredMethods()));
        //assert
        assertEquals(1, numberArgs);
    }

    @Test
    public void should_remove_the_received_damage_from_the_health_property()
    {
        Saxon.receiveDamage(50);
        assertEquals(10, Saxon.health);
    }

    @Test
    public void should_return_A_Saxon_has_received_DAMAGE_points_of_damage_if_the_Saxon_is_still_alive()
    {
        Saxon.receiveDamage(45);
        assertEquals("A Saxon has received " + 45 + " points of damage", Saxon.getMsg());
    }

    @Test
    public void should_return_A_Saxon_has_died_in_combat_if_the_Saxon_dies()
    {
        Saxon.receiveDamage(health);
        assertEquals("A Saxon has died in combat", Saxon.getMsg());
    }
}