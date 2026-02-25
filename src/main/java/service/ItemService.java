package service;

public interface ItemService
{
	public void addOrUpdateItem(String playerId, int itemId, long quantity);
	public long getItem(String playerId, int itemId);
}
