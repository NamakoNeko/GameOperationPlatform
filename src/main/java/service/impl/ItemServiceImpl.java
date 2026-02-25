package service.impl;

import dao.impl.ItemDaoImpl;
import dao.impl.PlayerDaoImpl;
import service.ItemService;

public class ItemServiceImpl implements ItemService
{
	///*
	public static void main(String[] args)
	{
		new ItemServiceImpl().addOrUpdateItem("P1771912517385", 1, 100);
	}
	//*/
	ItemDaoImpl itemDaoImpl = new ItemDaoImpl();
	PlayerDaoImpl playerDaoImpl = new PlayerDaoImpl();
	
	@Override
	public void addOrUpdateItem(String playerId, int itemId, long quantity)
	{
		if(playerId.isEmpty())
		{
			return;
		}
		else
		{
			if (playerDaoImpl.findPlayer(playerId) == null)
			{
				return;
			}
		}
		
		if (itemId <= 0 || quantity <= 0)
		{
			return;
		}
		
		if (getItem(playerId, itemId) < 0)
		{
			itemDaoImpl.addItem(playerId, itemId, quantity);
		}
		else
		{
			itemDaoImpl.updateItemAmount(playerId, itemId, quantity);
		}
	}

	@Override
	public long getItem(String playerId, int itemId)
	{
		return itemDaoImpl.getItem(playerId, itemId);
	}
}
