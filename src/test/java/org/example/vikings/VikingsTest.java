package org.example.vikings;

import org.example.soldier.Soldier;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class VikingTest {
    String name = "Harald";
    int strength = 150;
    int health = 300;

    Vikings viking = new Vikings(name, health, strength, "");

    @Test
    public void should_inherit_from_Soldier()
    {
        assertNotNull(viking instanceof Soldier);
    }

    @Test
    public void should_receive_4_arguments()
    {
        // Arrange
        Class<Vikings> vikings = Vikings.class;
        Constructor[] vikingCons = vikings.getConstructors();
        // Act
        int params = vikingCons[0].getParameterCount();
        //Assert
        System.out.println(Arrays.toString(vikingCons));
        assertEquals(4, params);
    }

    @Test
    public void should_receive_the_name_property_as_its_1st_argument()
    {
        // Arrange
        Field[] vikingFields = Vikings.class.getDeclaredFields();
        String  nameParam = vikingFields[0].toString();
        // Act
        System.out.println(Arrays.toString(vikingFields));
        int     firstParamName = nameParam.indexOf("name");
        //Assert
        assertTrue(firstParamName > 0 );
    }

    @Test
    public void should_receive_the_health_property_as_its_2st_argument()
    {
        // Arrange
        Field[] vikingFields = Vikings.class.getFields();
        String  healthParam = vikingFields[0].toString();
        // Act
        System.out.println(Arrays.toString(vikingFields));
        int     secondParamHealth = healthParam.indexOf("health");
        //Assert
        assertTrue(secondParamHealth > 0 );
    }

    @Test
    public void should_receive_the_health_property_as_its_3st_argument()
    {
        // Arrange
        Field[] vikingFields = Vikings.class.getFields();
        String  strengthParam = vikingFields[1].toString();
        // Act
        System.out.println(Arrays.toString(vikingFields));
        int     thirdParamStrength = strengthParam.indexOf("strength");
        //Assert
        assertTrue(thirdParamStrength > 0 );
    }

    @Test
    public void attack_should_return_strength_property_of_the_Viking()
    {
        int resultAttack = Vikings.attack();
        assertEquals(Vikings.strength, resultAttack);
    }

    @Test
    public void attack_should_receive_0_arguments()
    {
        //Arrange
        String  attackMethod = Vikings.class.getDeclaredMethods()[0].toString();
        //Act
        int     hasNoArgs = attackMethod.indexOf("attack()");
//        System.out.println(Arrays.toString(Soldier.class.getDeclaredMethods()));
        //Assert
        assertTrue(hasNoArgs > 0);
    }

    @Test
    public void receiveDamage_should_receive_1_arguments()
    {
        //arrange
        Class<Vikings> viking = Vikings.class;
        //act
        int numberArgs = viking.getDeclaredMethods()[1].getParameterCount();
        System.out.println(numberArgs);
        //assert
        assertEquals(numberArgs, 1);
    }

    @Test
    public void should_remove_the_received_damage_from_the_health_property()
    {
        Vikings.receiveDamage(50);
        assertEquals(250, Vikings.health);
    }

    @Test
    public void should_return_NAME_has_received_DAMAGE_points_of_damage_if_the_Viking_is_still_alive()
    {
        Vikings.receiveDamage(50);
        assertEquals(Vikings.name + " has received " + 50 + " points of damage", Vikings.getMsg());
    }

    @Test
    public void should_return_NAME_has_died_in_act_of_combat_if_the_Viking_dies()
    {
        Vikings.receiveDamage(health);
        assertEquals(Vikings.name + " has died in act of combat", Vikings.getMsg());
    }

    @Test
    public void battleCry_should_receive_0_arguments()
    {
        //arrange
        Class<Vikings> viking = Vikings.class;
        //act
        int numberArgs = viking.getDeclaredMethods()[3].getParameterCount();
        System.out.println(numberArgs);
        //assert
        assertEquals(numberArgs, 0);
    }

    @Test
    public void should_return_Odin_Owns_You_All_()
    {
        String battleCry = Vikings.battleCry();
        assertEquals("Odin Owns You All!", battleCry);
    }
}