package org.example.soldier;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.*;

class SoldierTest {
    int strength = 150;
    int health = 300;

    @Test
    public void should_receive_2_arguments()
    {
        // Arrange
        Class<Soldier> soldier = Soldier.class;
        Constructor[] soldierCons = soldier.getConstructors();
        // Act
        int params = soldierCons[0].getParameterCount();
        //Assert
        System.out.println(params);
        assertEquals(params, 2);
    }

    @Test
    public void should_receive_the_health_property_as_its_1st_argument()
    {
        // Arrange
        Field[] soldierFields = Soldier.class.getFields();
        String  healthParam = soldierFields[0].toString();
        // Act
        int     firstParamHealth = healthParam.indexOf("health");
        //Assert
        assertTrue(firstParamHealth > 0 );
    }

    @Test
    public void should_receive_the_health_property_as_its_2st_argument()
    {
        // Arrange
        Field[] soldierFields = Soldier.class.getFields();
        String  strengthParam = soldierFields[1].toString();
        // Act
        int     secondParamStrength = strengthParam.indexOf("strength");
        //Assert
        assertTrue(secondParamStrength > 0 );
    }

    @Test
    public void attack_should_receive_0_arguments()
    {
        //Arrange
        String  attackMethod = Soldier.class.getDeclaredMethods()[0].toString();
        //Act
        int     hasNoArgs = attackMethod.indexOf("attack()");
//        System.out.println(Arrays.toString(Soldier.class.getDeclaredMethods()));
        //Assert
        assertTrue(hasNoArgs > 0);
    }

    @Test
    public void attack_should_return_a_integer()
    {
        //arrange, act
        int resultAttack = Soldier.attack();
        //assert
        assertEquals("Integer", ((Object) resultAttack).getClass().getSimpleName());
    }

    @Test
    public void attack_should_return_the_strength_property_of_the_Soldier()
    {
        //arrange
        Soldier soldier = new Soldier(health, strength);
        //act
        int resultAttack = soldier.attack();
        //assert
        assertEquals(150, resultAttack);
    }

    @Test
    public void receiveDamage_should_receive_1_arguments()
    {
        //arrange
        Class<Soldier> soldier = Soldier.class;
        //act
        int numberArgs = soldier.getDeclaredMethods()[1].getParameterCount();
        System.out.println(numberArgs);
        //assert
        assertEquals(numberArgs, 1);
    }

    @Test
    public void should_remove_the_received_damage_from_the_health_property()
    {
        Soldier soldier = new Soldier(health, strength);
        soldier.receiveDamage(30);
        assertEquals(270, soldier.health);
    }
}