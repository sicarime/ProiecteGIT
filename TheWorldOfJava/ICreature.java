package TheWorldOfJava;

public interface ICreature 
{
	String getNickname();
	void setNickname(String nickName);
	void updateScore(long amount) throws NumberFormatException;
	void powerUp(double stamina, double speed, int agility);
}
