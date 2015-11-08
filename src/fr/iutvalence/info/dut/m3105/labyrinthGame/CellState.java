package fr.iutvalence.info.dut.m3105.labyrinthGame;

/**
 * Enum allowing to handle cell states
 * 
 */
public enum CellState
{
	FREE, FORBIDDEN, EXIT;

	public String toString()
	{
		switch (this)
		{
			case FREE:
				return "=";
			case FORBIDDEN:
				return "X";
			case EXIT:
			default:
				return "E";
		}
	}
}
