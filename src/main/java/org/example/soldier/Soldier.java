package org.example.soldier;

public class Soldier
{
    public static int health;
    public static int strength;

    public Soldier(int health, int strength)
    {
        this.health = health;
        this.strength = strength;
    }

    public static int attack()
    {
        return (strength);
    }

    public static void receiveDamage(int damage)
    {
        health = health - damage;
    }
}
