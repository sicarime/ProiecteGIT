package TheWorldOfJava;

public class Dragons extends Creature implements IBurn
{
	protected double flamesPower;
	protected int flySpeed;
	
	public Dragons (double stamina, double speed, int agility, String nickName, long score, double flamesPower, int flySpeed)
	{
		super(stamina, speed, agility, nickName, score);
		this.flamesPower = flamesPower;
		this.flySpeed = flySpeed;
	}

	@Override
	public double getFlamesPower() {
		// TODO Auto-generated method stub
		return this.flamesPower;
	}

	@Override
	public int getFlyingSpeed() {
		// TODO Auto-generated method stub
		return this.flySpeed;
	}

	@Override
	public void powerUp(double newStamina, double newSpeed, int newAgility) {
		// TODO Auto-generated method stub
//		super.powerUp(stamina, speed, agility);
		this.abilities.stamina += 2 * newStamina;
		this.abilities.speed += newSpeed / 2;
		this.abilities.agility += 3 * newAgility;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "\n" +
				"Flames power: " + this.flamesPower + "\n" +
				"Fly speed: " + this.flySpeed;
	}
	
	
	
	
}
