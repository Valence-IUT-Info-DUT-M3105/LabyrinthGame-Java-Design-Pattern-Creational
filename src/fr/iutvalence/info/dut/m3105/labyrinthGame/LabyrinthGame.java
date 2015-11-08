package fr.iutvalence.info.dut.m3105.labyrinthGame;


/**
 * Class representing a game of "escape labyrinth if you can"
 * 
 */
public class LabyrinthGame
{
	private final Labyrinth labyrinth;

	private final RobotArtificialIntelligence robotAI;

	private Position robotPosition;

	private Direction robotDirection;

	private int turnNumber;

	public LabyrinthGame(Labyrinth labyrinth, RobotArtificialIntelligence robotAI)
	{
		this.labyrinth = labyrinth;
		this.robotAI = robotAI;
		this.robotPosition = this.labyrinth.getStartingPosition();
		this.robotDirection = Direction.NORTH;

		this.turnNumber = 1;
	}

	public void play()
	{
		loopUntilRobotHasReachedExit();

		System.out.println("Robot has reached the exit in " + this.turnNumber + " turns");
	}

	private void loopUntilRobotHasReachedExit()
	{
		while (true)
		{
			if (hasRobotReachedExit())
				break;

			processRobotAction();

			this.turnNumber += 1;
		}
	}

	private void processRobotAction()
	{
		Action action = this.robotAI.getAction();
		Position oldRobotPosition = this.robotPosition;
		Direction oldRobotDirection = this.robotDirection;
		
		switch (action)
		{
			case MOVE_FORWARD:
				processMoveForwardAction();		
				break;
			case TURN_LEFT:
				processTurnLeftAction();
				break;
			case TURN_RIGHT:
				processTurnRightAction();
				break;
			case U_TURN:
				processUTurnAction();
				break;

			case SCAN:
			default:
				processScanAction();
				break;
		}
		
		System.out.println(new TurnInfo(turnNumber, oldRobotPosition, oldRobotDirection, action, this.robotPosition, this.robotDirection));
	}

	private void processScanAction()
	{
		// not yet implemented		
	}

	private void processUTurnAction()
	{
		this.robotDirection = this.robotDirection
				.getResultingDirectionAfterUTurn();
	}

	private void processTurnRightAction()
	{
		this.robotDirection = this.robotDirection.getResultingDirectionAfterRightTurn();
	}

	private void processTurnLeftAction()
	{
		this.robotDirection = this.robotDirection
				.getResultingDirectionAfterLeftTurn();
	}

	private void processMoveForwardAction()
	{
		Position resultingPosition = this.labyrinth.getResultingPositionWhenMoving(this.robotPosition,
				this.robotDirection);
		boolean hasMoved = !(resultingPosition.equals(this.robotPosition));
		this.robotPosition = resultingPosition;
		this.robotAI.notifyMoveResult(hasMoved);
	}

	private boolean hasRobotReachedExit()
	{
		return this.labyrinth.getCellStateAt(this.robotPosition) == CellState.EXIT;
	}
}
