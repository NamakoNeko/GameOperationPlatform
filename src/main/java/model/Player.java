package model;

public class Player
{
	private Long id;
	private String uid;
	private String playerName;
	private int level;
	private int exp;
	private int gold;	
	
	public Player() {}

	public Player(String uid, String playerName, int level, int exp, int gold)
	{
		super();
		this.uid = uid;
		this.playerName = playerName;
		this.level = level;
		this.exp = exp;
		this.gold = gold;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getUid()
	{
		return uid;
	}

	public void setUid(String uid)
	{
		this.uid = uid;
	}

	public String getPlayerName()
	{
		return playerName;
	}

	public void setPlayerName(String username)
	{
		this.playerName = username;
	}

	public int getLevel()
	{
		return level;
	}

	public void setLevel(int level)
	{
		this.level = level;
	}

	public int getExp()
	{
		return exp;
	}

	public void setExp(int exp)
	{
		this.exp = exp;
	}

	public int getGold()
	{
		return gold;
	}

	public void setGold(int gold)
	{
		this.gold = gold;
	}
	
}
