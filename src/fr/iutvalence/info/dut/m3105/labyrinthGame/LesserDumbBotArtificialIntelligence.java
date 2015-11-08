package fr.iutvalence.info.dut.m3105.labyrinthGame;

import java.util.Random;

public class LesserDumbBotArtificialIntelligence implements RobotArtificialIntelligence
{
	private boolean isBlocked;
	
	private final Random random;

	public LesserDumbBotArtificialIntelligence()
	{
		this.isBlocked = false;
		this.random = new Random();
	}

	@Override
	public Action getAction()
	{
		if (this.isBlocked)
		{
			this.isBlocked = false;
			
			switch (this.random.nextInt(3))
			{
				case 0 : 
					return Action.TURN_LEFT;
				case 1 : 
					return Action.TURN_RIGHT;
				case 2 :
				default :
					return Action.U_TURN;
			}
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
