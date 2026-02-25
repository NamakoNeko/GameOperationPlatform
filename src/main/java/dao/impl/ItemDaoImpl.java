package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ItemDao;
import util.Utility;

public class ItemDaoImpl implements ItemDao
{

	public static void main(String[] args)
	{
		
	}
	
	Connection conn = Utility.getConnection();
	@Override
	public void addItem(String playerId, int itemId, long quantity)
	{
		String sql = "INSERT INTO inventory(player_id,item_id,quantity) VALUES(?,?,?)";
		
		PreparedStatement ps;
		try
		{
			ps = conn.prepareStatement(sql);
			ps.setString(1, playerId);
			ps.setInt(2, itemId);
			ps.setLong(3, quantity);
			ps.executeUpdate();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public long getItem(String playerId, int itemId)
	{
		String sql = "SELECT quantity FROM inventory WHERE player_id=? AND item_id=?";
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, playerId);
			ps.setInt(2, itemId);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("quantity");
			}
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}

	@Override
	public void updateItemAmount(String playerId, int itemId, long quantity)
	{
		 String sql = "UPDATE inventory SET quantity=? WHERE player_id=? AND item_id=?";

		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, quantity);
			ps.setString(2, playerId);
			ps.setInt(3, itemId);
			
			ps.executeUpdate();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
