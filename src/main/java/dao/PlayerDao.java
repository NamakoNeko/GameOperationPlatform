package dao;

import java.util.List;

import model.Player;

public interface PlayerDao
{
	public void addPlayer(Player player);
	public Player findPlayer(String uid);
	public List<Player> findAll();
	public void updatePlayer(Player player);
	public void deletePlayer(String uid);
	public void updateLevel(String uid, int level);
}
