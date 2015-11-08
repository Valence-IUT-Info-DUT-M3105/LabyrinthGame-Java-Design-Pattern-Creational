package fr.iutvalence.info.dut.m3105.labyrinthGame;

/**
 * Enum allowing to handle two-axis directions
 * 
 */
public enum Direction
{
	NORTH, SOUTH, EAST, WEST;

	public Direction getResultingDirectionAfterLeftTurn()
	{
		switch (this)
		{
			case NORTH:
				return WEST;
			case SOUTH:
				return EAST;
			case EAST:
				return NORTH;
			case WEST:
			default:
				return SOUTH;
		}
	}
	
	public Direction getResultingDirectionAfterRightTurn()
	{
		switch (this)
		{
			case NORTH:
				return EAST;
			case SOUTH:
				return WEST;
			case EAST:
				return SOUTH;
			case WEST:
			default:
				return NORTH;
		}
	}
	
	public Direction getResultingDirectionAfterUTurn()
	{
		switch (this)
		{
			case NORTH:
				return SOUTH;
			case SOUTH:
				return NORTH;
			case EAST:
				return WEST;
			case WEST:
			default:
				return EAST;
		}
	}
	
	public String toString()
	{
		switch (this)
		{
			case NORTH:
				return "N";
			case SOUTH:
				return "S";
			case EAST:
				return "E";
			case WEST:
			default:
				return "W";
		}
	}
}
