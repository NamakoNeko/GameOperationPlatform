package dao;

public interface ItemDao
{	
	public void addItem(String playerId, int itemId, long quantity);
	public long getItem(String playerId, int itemId);
	public void updateItemAmount(String playerId, int itemId, long quantity);
}
