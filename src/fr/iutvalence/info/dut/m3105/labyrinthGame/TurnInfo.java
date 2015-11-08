package fr.iutvalence.info.dut.m3105.labyrinthGame;

/**
 * Class representing a turn of labyrinth game (turn number, starting position,
 * moving direction, resulting position)
 * 
 */
public class TurnInfo
{
	private final int turnNumber;

	private final Position startingPosition;
	
	private final Direction startingDirection;

	private final Action action;

	private final Position resultingPosition;
	
	private final Direction resultingDirection;

	/**
	 * Constructs a new TurnInfo instance, with given turn number, starting
	 * position and direction, action and resulting position and direction
	 * 
	 */
	public TurnInfo(int turnNumber, Position startingPosition, Direction startingDirection, Action action, Position resultingPosition, Direction resultingDirection)
	{
		this.turnNumber = turnNumber;
		this.startingPosition = startingPosition;
		this.startingDirection = startingDirection;
		this.action = action;
		this.resultingPosition = resultingPosition;
		this.resultingDirection = resultingDirection;
	}

	public int getTurnNumber()
	{
		return this.turnNumber;
	}
	
	public Action getAction()
	{
		return this.action;
	}

	public Position getStartingPosition()
	{
		return this.startingPosition;
	}

	public Position getResultingPosition()
	{
		return this.resultingPosition;
	}

	public Direction getStartingDirection()
	{
		return this.startingDirection;
	}

	public Direction getResultingDirection()
	{
		return this.resultingDirection;
	}
	
	public String toString()
	{
		String result = "Robot starts turn " + this.turnNumber + " at " + this.startingPosition + ", heading "+this.startingDirection+"\n";
		result += "Robot action is " + this.action + "\n";
		result += "Robot ends turn " + this.turnNumber + " at " + this.resultingPosition + ", heading "+this.resultingDirection+"\n";
		return result;
	}
}
