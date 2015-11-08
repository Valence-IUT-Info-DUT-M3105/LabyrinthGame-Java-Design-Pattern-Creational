package fr.iutvalence.info.dut.m3105.labyrinthGame;

/**
 * Class representing a position in a two-axis coordinate system
 * 
 */
public class Position
{
	private final int x;

	private final int y;

	public Position(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public int getX()
	{
		return this.x;
	}

	public int getY()
	{
		return this.y;
	}

	public Position getNeighbourPosition(Direction direction)
	{
		switch (direction)
		{
			case NORTH:
				return new Position(this.x, this.y - 1);
			case SOUTH:
				return new Position(this.x, this.y + 1);
			case EAST:
				return new Position(this.x + 1, this.y);
			case WEST:
			default:
				return new Position(this.x - 1, this.y);
		}
	}

	@Override
	public String toString()
	{
		return "(" + this.x + "," + this.y + ")";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}	
}
