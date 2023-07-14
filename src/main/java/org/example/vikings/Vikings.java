package org.example.vikings;
import org.example.soldier.Soldier;
public class Vikings extends Soldier
{
    static String name;
    static String msg;
    public Vikings(String name, int health, int strength, String msg)
    {
        super(health, strength);
        this.name = name;
    }

    public static int attack()
    {
        return (strength);
    }

    public static void receiveDamage(int damage)
    {
        health = health - damage;
        if (health <= 0)
            msg = name + " has died in act of combat";
        else
            msg = name + " has received " + damage + " points of damage";
    }

    public static String battleCry()
    {
        return ("Odin Owns You All!");
    }

    public static String getMsg()
    {
        return (msg);
    }

    public static int getStrength()
    {
        return (strength);
    }

    public static int getHealth()
    {
        return (health);
    }

    public static String getName()
    {
        return (name);
    }

    public static void setHealth(int givenHealth)
    {
        health = givenHealth;
    }
}
