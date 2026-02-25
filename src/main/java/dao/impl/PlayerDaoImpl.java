package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PlayerDao;
import model.Player;
import util.Utility;

public class PlayerDaoImpl implements PlayerDao
{
	/*
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	*/
	Connection conn = Utility.getConnection();

	@Override
	public void addPlayer(Player player)
	{
		String sql = "INSERT INTO player(player_id, player_name, level, exp, gold) VALUES(?,?,?,?,?)";
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, player.getUid());
			ps.setString(2, player.getPlayerName());
			ps.setInt(3, player.getLevel());
			ps.setInt(4, player.getExp());
			ps.setInt(5, player.getGold());
			
			ps.executeUpdate();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Player findPlayer(String uid)
	{
		String sql = "SELECT * FROM player WHERE player_id=?";
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next())
			{
				Player p = new Player();
				p.setUid(rs.getString("player_id"));
                p.setId(rs.getLong("id"));
                p.setPlayerName(rs.getString("player_name"));
                p.setLevel(rs.getInt("level"));
                p.setExp(rs.getInt("exp"));
                p.setGold(rs.getInt("gold"));
                
                return p;
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Player> findAll()
	{
		List<Player> list = new ArrayList<>();
		String sql = "SELECT * FROM player";
		
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) 
			{
				Player p = new Player();
				p.setId(rs.getLong("id"));
				p.setPlayerName(rs.getString("player_name"));
				p.setLevel(rs.getInt("level"));
				p.setExp(rs.getInt("exp"));
				p.setGold(rs.getInt("gold"));
				list.add(p);
			}
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

       return list;
	}

	@Override
	public void updatePlayer(Player player)
	{
		String sql = "update player set player_name = ?, level = ?, exp = ?, gold = ? where player_id = ?";
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, player.getPlayerName());
			ps.setInt(2, player.getLevel());
			ps.setInt(3, player.getExp());
			ps.setInt(4, player.getGold());
			ps.setString(5, player.getUid());
			
			ps.executeUpdate();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deletePlayer(String uid)
	{
		String sql = "DELETE FROM player WHERE player_id=?";
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			ps.executeUpdate();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateLevel(String uid, int level)
	{
		String sql = "UPDATE player SET level=? WHERE player_id=?";

	    try 
	    {
	    		PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, level);
	        ps.setString(2, uid);
	        ps.executeUpdate();
	    } catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
