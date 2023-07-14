package org.example.saxon;
import org.example.soldier.Soldier;

public class Saxon extends Soldier
{
    static String   msg;
    public Saxon(int health, int strength, String msg)
    {
        super(health, strength);
    }

    public static int attack()
    {
        return (strength);
    }

    public static void receiveDamage(int damage)
    {
        health = health - damage;
        if (health > 0)
            msg = "A Saxon has received " + damage + " points of damage";
        else
            msg = "A Saxon has died in combat";
    }

    public static String getMsg()
    {
        return (msg);
    }

    public static int getHealth()
    {
        return (health);
    }

    public static void setHealth(int givenHealth)
    {
        health = givenHealth;
    }

    public static int getStrength()
    {
        return (strength);
    }
}
