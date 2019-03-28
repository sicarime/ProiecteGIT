package TheWorldOfJava;

public class Wargs extends Creature implements IBite
{
	protected double bitePower;
	
	public Wargs(double stamina, double speed, int agility, String nickName, long score, double bitePower)
	{
		super(stamina, speed, agility, nickName, score);
		this.bitePower = bitePower;
	}

	@Override
	public double getBitePower() {
		// TODO Auto-generated method stub
		return this.bitePower;
	}

	@Override
	public String toString() {
		return super.toString() + "\n" +
				"Bite power: " + this.bitePower + "\n";
	}

	@Override
	public void powerUp(double newStamina, double newSpeed, int newAgility) 
	{
		// TODO Auto-generated method stub
//		super.powerUp(stamina, speed, agility);
		this.abilities.stamina += newStamina / 2;
		this.abilities.speed += 4 * newSpeed;
		this.abilities.agility += newAgility;
	}
	
	
	
	
}
