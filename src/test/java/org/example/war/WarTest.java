package org.example.war;
import org.example.saxon.Saxon;
import org.example.vikings.Vikings;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class WarTest
{
    String name = "Harald";
    int strength = 150;
    int health = 300;

    Saxon saxon = new Saxon(health, strength, "");
    Vikings viking = new Vikings(name, health, strength, "");
    War war = new War();

    @Test
    public void should_receive_0_arguments()
    {
        // Arrange
        Class<War> war = War.class;
        Constructor[] warCons = war.getConstructors();
        // Act
        int params = warCons[0].getParameterCount();
        //Assert
        System.out.println(Arrays.toString(warCons));
        assertEquals(0, params);
    }

    @Test
    public void should_assign_an_empty_array_to_the_vikingArmy_property()
    {
        ArrayList<Vikings> vikingArmy = war.getVikingArmy();
        assertTrue(vikingArmy.isEmpty());
    }

    @Test
    public void should_assign_an_empty_array_to_the_saxonArmy_property()
    {
        ArrayList<Saxon> saxonArmy = war.getSaxonArmy();
        assertTrue(saxonArmy.isEmpty());
    }

    @Test
    public void add_viking_should_receive_1_argument()
    {
        //arrange
        Class<War> war = War.class;
        //act
        int numberArgs;
        try
        {
            numberArgs = war.getMethod("addViking", Vikings.class).getParameterCount();
        }
        catch (NoSuchMethodException e)
        {
            throw new RuntimeException(e);
        }
        //assert
        assertEquals(1, numberArgs);
    }

    @Test
    public void add_viking_should_add_a_Viking_to_the_army()
    {
        War.addViking(viking);
        assertNotNull(War.getVikingArmy());
    }

    @Test
    public void add_saxon_should_add_a_Saxon_to_the_army()
    {
        War.addSaxon(saxon);
        assertNotNull(War.getVikingArmy());
    }

    @Test
    public void vikingAttack_should_make_Saxon_receiveDamage_equal_to_the_strength_of_a_Viking()
    {
        War.addSaxon(saxon);
        War.addViking(viking);
        int oldHealth = saxon.getHealth();
        int actualHealth = oldHealth - viking.getStrength();
        War.vikingAttack();
        assertEquals(saxon.getHealth(), actualHealth);
    }

    @Test
    public void vikingAttack_should_remove_dead_saxons_from_the_army()
    {
        War.addSaxon(saxon);
        War.addViking(viking);
        saxon.setHealth(150);
        War.vikingAttack();
        assertTrue(War.getSaxonArmy().isEmpty());
    }

    @Test
    public void vikingAttack_should_return_result_of_calling_receiveDamage_of_a_Saxon_with_the_strength_of_a_Viking()
    {
        War.addSaxon(saxon);
        War.addViking(viking);
        Saxon.setHealth(150);
        String response = War.vikingAttack();
        assertEquals("A Saxon has died in combat", response);
    }

    @Test
    public void saxonAttack_should_make_Viking_receiveDamage_equal_to_the_strength_of_a_Viking()
    {
        War.addSaxon(saxon);
        War.addViking(viking);
        int oldHealth = viking.getHealth();
        int actualHealth = oldHealth - saxon.getStrength();
        war.saxonAttack();
        assertEquals(viking.getHealth(), actualHealth);
    }

    @Test
    public void saxonAttack_should_remove_dead_viking_from_the_army()
    {
        War.addSaxon(saxon);
        War.addViking(viking);
        viking.setHealth(150);
        War.saxonAttack();
        assertTrue(War.getVikingArmy().isEmpty());
    }

    @Test
    public void saxonAttack_should_return_a_message_with_the_name_of_the_dead_viking()
    {
        War.addSaxon(saxon);
        War.addViking(viking);
        viking.setHealth(150);
        String response = War.saxonAttack();
        assertEquals(Vikings.getName() + " has died in act of combat", response);
    }

    @Test
    public void saxonAttack_should_return_result_of_calling_receiveDamage_of_a_Viking_with_the_strength_of_a_Saxon()
    {
        War.addSaxon(saxon);
        War.addViking(viking);
        String response = War.saxonAttack();
        assertEquals(Vikings.getName() + " has received " + saxon.getStrength() + " points of damage", response);
    }
}