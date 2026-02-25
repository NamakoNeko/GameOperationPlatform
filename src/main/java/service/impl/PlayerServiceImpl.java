package service.impl;

import java.util.List;

import dao.impl.PlayerDaoImpl;
import model.Player;
import service.PlayerService;
import util.Utility;

public class PlayerServiceImpl implements PlayerService
{
	PlayerDaoImpl daoImpl = new PlayerDaoImpl();
	/*
	public static void main(String[] args)
	{
		
	}
	*/
	@Override
	public boolean addPlayer(String playerName)
	{
		if (playerName.isEmpty())
		{
			return false;
		}
		
		Player p = new Player();
        p.setUid(Utility.generateUID());
        p.setPlayerName(playerName);
        p.setLevel(1);
        p.setExp(0);
        p.setGold(100);
		
        daoImpl.addPlayer(p);
        return true;
	}

	@Override
	public Player findPlayer(String uid)
	{
		return daoImpl.findPlayer(uid);
	}

	@Override
	public List<Player> findAll()
	{
		return daoImpl.findAll();
	}

	@Override
	public void updatePlayer(Player player)
	{
		daoImpl.updatePlayer(player);
	}

	@Override
	public void deletePlayer(String uid)
	{
		daoImpl.deletePlayer(uid);
	}

	@Override
	public void updateLevel(String uid, int level)
	{
		if(uid.isEmpty())
		{
			return;
		}
		
		if(level <= 0)
		{
			return;
		}
		
		daoImpl.updateLevel(uid, level);
	}
	
}