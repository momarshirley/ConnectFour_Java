package connectFourProgram;

//	interface defines methods that all players implement
public interface Player {
	
	void init(Boolean color);	//	sets player's color to red or yellow
	String name();				//	gets players name
	int move();					//	makes move
	void inform(int column);	//	inform player about opponents move
}