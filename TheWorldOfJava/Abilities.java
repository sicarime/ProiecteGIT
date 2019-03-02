package TheWorldOfJava;

public class Abilities implements Comparable<Abilities>
{
	protected double stamina;
	protected double speed;
	protected int agility;
	
	public Abilities(double stamina, double speed, int agility)
	{
		this.stamina = stamina;
		this.speed = speed;
		this.agility = agility;
	}

	protected void update(double stamina, double speed, int agility)
	{
		this.stamina += stamina;
		this.speed += speed;
		this.agility += agility;
	}
	
	protected int powerDiffernceApprox(Abilities other)
	{
		return (int) Math.abs(this.stamina - other.stamina);
	}
	
	@Override
	public int compareTo(Abilities other) {
//		double error = 0.000001;
		int compStamina = Double.compare(this.stamina, other.stamina);
		int compSpeed = Double.compare(this.speed, other.speed);
		
		if (compStamina < 0) 
		{
			return -1;
		}
		else if (compStamina > 0)
			{
				return 1;
			}
			else 
			{
				if (compSpeed < 0) 
				{
					return -1;
				}
				else if (compSpeed > 0)
				{
					return 1;
				}
				else 
				{
					if (this.agility < other.agility)
					{
						return -1;
					}
					else if (this.agility > other.agility) 
					{
						return 1;
					}
					else return 0;
				}

			}
	}

	@Override
	public String toString() {
		
		return "Player has a power of: " + this.stamina +
				", the speed: " + this.speed + 
				" and agility: " + this.agility;
	}
	
	
	
}
