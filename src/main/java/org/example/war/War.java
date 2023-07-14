package org.example.war;
import org.example.vikings.Vikings;
import org.example.saxon.Saxon;
import java.util.ArrayList;
import java.security.SecureRandom;

public class War
{
    static ArrayList<Vikings> vikingArmy;
    static ArrayList<Saxon> saxonArmy;
    public War()
    {
        vikingArmy = new ArrayList<>();
        saxonArmy = new ArrayList<>();
    }
    public static void addViking(Vikings viking)
    {
        vikingArmy.add(viking);
    }

    public static void addSaxon(Saxon saxon)
    {
        saxonArmy.add(saxon);
    }

    public static String vikingAttack()
    {
        SecureRandom rand = new SecureRandom();
        Vikings randomViking;
        Saxon   randomSaxon;
        int     randomNumber;

        randomNumber = rand.nextInt(saxonArmy.size());
        randomViking = vikingArmy.get(rand.nextInt(vikingArmy.size()));
        randomSaxon = saxonArmy.get(randomNumber);
        randomSaxon.receiveDamage(randomViking.strength);
        if (randomSaxon.health <= 0)
            saxonArmy.remove(randomNumber);
        return (Saxon.getMsg());
    }

    public static String saxonAttack()
    {
        SecureRandom rand = new SecureRandom();
        Vikings randomViking;
        Saxon   randomSaxon;
        int     randomNumber;

        randomNumber = rand.nextInt(vikingArmy.size());
        randomSaxon = saxonArmy.get(rand.nextInt(saxonArmy.size()));
        randomViking = vikingArmy.get(randomNumber);
        randomViking.receiveDamage(randomSaxon.strength);
        if (randomViking.health <= 0)
            vikingArmy.remove(randomNumber);
        return (Vikings.getMsg());
    }

    public static String showStatus()
    {
        if (saxonArmy.size() == 0)
            return ("Vikings have won the war of the century!");
        else if (vikingArmy.size() == 0)
            return ("Saxons have fought for their lives and survive another day...");
        return ("Vikings and Saxons are still in the thick of battle.");
    }

    public static ArrayList getVikingArmy()
    {
        return (vikingArmy);
    }

    public static ArrayList getSaxonArmy()
    {
        return (saxonArmy);
    }
}
