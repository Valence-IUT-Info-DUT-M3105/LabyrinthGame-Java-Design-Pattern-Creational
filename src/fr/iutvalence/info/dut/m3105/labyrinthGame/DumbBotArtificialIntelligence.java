package fr.iutvalence.info.dut.m3105.labyrinthGame;

public class DumbBotArtificialIntelligence implements RobotArtificialIntelligence
{
	private boolean isBlocked;

	public DumbBotArtificialIntelligence()
	{
		this.isBlocked = false;
	}

	@Override
	public Action getAction()
	{
		if (this.isBlocked)
		{
			this.isBlocked = false;
			return Action.TURN_LEFT;
		}

		return Action.MOVE_FORWARD;
	}

	@Override
	public void notifyScanResult(int distancesToWallsInEachDirection)
	{
	}

	@Override
	public void notifyMoveResult(boolean hasMoved)
	{
		this.isBlocked = !hasMoved;
	}
}
