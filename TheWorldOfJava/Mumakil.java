package TheWorldOfJava;

public class Mumakil extends Creature
{
	public Mumakil(double stamina, double speed, int agility, String nickName, long score)
	{
		super(stamina, speed, agility, nickName, score);
	}

	@Override
	public void powerUp(double newStamina, double newSpeed, int newAgility) {
		// TODO Auto-generated method stub
//		super.powerUp(stamina, speed, agility);
		this.abilities.stamina += 0.75 * newStamina;
		this.abilities.speed += newSpeed + 10;
		this.abilities.agility += newAgility;
	}

	@Override
	public String toString() {
		return super.toString() + "\nA creature of type Mumakil.";
	}
}
