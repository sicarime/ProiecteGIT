package TheWorldOfJava;

import java.lang.Throwable;

public abstract class Creature implements ICreature, Comparable<Creature>
{
	protected Abilities abilities;
	protected String nickName;
	protected long score;
	
	public Creature (double stamina, double speed, int agility, String nickName, long score)
	{
		this.abilities.stamina = stamina;
		this.abilities.speed = speed;
		this.abilities.agility = agility;
		this.nickName = nickName;
		this.score = score;
		
	}

	@Override
	public int compareTo(Creature other) {
		
		// TODO Auto-generated method stub
		return this.abilities.compareTo(other.abilities);
	}

	@Override
	public String getNickname() {
		// TODO Auto-generated method stub
		return this.nickName;
	}

	@Override
	public void setNickname(String nickName) {
		// TODO Auto-generated method stub
		this.nickName = nickName;
	}

	@Override
	public void updateScore(long amount) throws NumberFormatException {
		// TODO Auto-generated method stub
		if (amount < 0) 
		{
			throw new NumberFormatException("Expecting positive bonus value, got:" + amount);
		} 
		else 
		{ 
			this.score += amount;
		}
	}

	@Override
	public void powerUp(double stamina, double speed, int agility) {
		// TODO Auto-generated method stub
		this.abilities.update(stamina, speed, agility);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub	
		return "Nickname: " + this.nickName + "\n" +
				"Score: " + this.score + "\n" +
				"Abilities: " + abilities.toString();
	}
}
