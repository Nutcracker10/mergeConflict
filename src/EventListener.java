
public interface EventListener 
{
	void move(String colour, int from, int to);
	
	void cheat();
	
	void match(int p);

	void doubleCube(int p);
	
	void score(Player white, Player black);
}
