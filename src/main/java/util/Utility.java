package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

public class Utility
{
	/*
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	*/
	public static Connection getConnection()
	{
		String url = "jdbc:mysql://localhost:3306/game_operation_platform";
		String username = "root";
		String password = "1234";
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static String generateUID()
	{
		return "P" + System.currentTimeMillis();
	}
	
	public static void saveObject(Object object, String fileName)
	{
		try
		{
			FileOutputStream fos = new FileOutputStream(fileName + ".txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(object);
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Object readObject(String fileName)
	{
		Object object = null;
		try
		{
			FileInputStream fis = new FileInputStream(fileName + ".txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			object = ois.readObject();
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}
}
