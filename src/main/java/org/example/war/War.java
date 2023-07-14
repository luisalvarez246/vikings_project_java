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

    public static ArrayList getVikingArmy()
    {
        return (vikingArmy);
    }

    public static ArrayList getSaxonArmy()
    {
        return (saxonArmy);
    }
}
