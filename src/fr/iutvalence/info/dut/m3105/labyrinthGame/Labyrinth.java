package fr.iutvalence.info.dut.m3105.labyrinthGame;

import java.util.Set;

/**
 * Class representing a labyrinth. A labyrinth is a grid of cells, whose at
 * least one has an exit gate. The labyrinth is defined by the positions of
 * forbidden cells (surrounded by walls), and the exit position.
 */
public class Labyrinth
{
	private final int width;

	private final int height;

	private final Position exitPosition;

	private final Set<Position> forbiddenCellsPositions;

	/**
	 * Constructs a new labyrinth with given size and forbidden cell positions
	 * 
	 */
	public Labyrinth(int width, int height, Set<Position> forbiddenCellPositions, Position exitPosition)
	{
		this.width = width;
		this.height = height;
		this.exitPosition = exitPosition;
		this.forbiddenCellsPositions = forbiddenCellPositions;
	}

	public int getWidth()
	{
		return this.width;
	}

	public int getHeight()
	{
		return this.height;
	}

	private boolean isPositionOutOfBounds(Position position)
	{
		if (position.getX() < 0) return true;
		if (position.getX() >= this.width) return true;
		if (position.getY() < 0) return true;
		if (position.getY() >= this.height) return true;
		return false;
	}
	
	public CellState getCellStateAt(Position position)
	{
		if (this.isPositionOutOfBounds(position)) return CellState.FORBIDDEN;
		
		if (position.equals(this.exitPosition))
			return CellState.EXIT;

		if (this.forbiddenCellsPositions.contains(position))
			return CellState.FORBIDDEN;

		return CellState.FREE;
	}

	public Position getResultingPositionWhenMoving(Position startingPosition, Direction direction)
	{
		Position resultingPosition = startingPosition.getNeighbourPosition(direction);
		if (this.getCellStateAt(resultingPosition) == CellState.FORBIDDEN)
			resultingPosition = startingPosition;
		return resultingPosition;
	}

	public Position getStartingPosition()
	{
		return new Position(0,0);
	}
}
