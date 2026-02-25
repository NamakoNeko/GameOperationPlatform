package controller;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AdminController extends JFrame
{

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					AdminController frame = new AdminController();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminController()
	{
		setTitle("遊戲後台管理系統");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel title = new JLabel("遊戲後台控制台");
        title.setBounds(180, 40, 200, 30);
        add(title);

        JButton btnPlayer = new JButton("玩家管理");
        btnPlayer.setBounds(150, 120, 200, 40);
        add(btnPlayer);

        JButton btnInventory = new JButton("道具管理");
        btnInventory.setBounds(150, 180, 200, 40);
        add(btnInventory);
        
        // 開啟玩家管理視窗
        btnPlayer.addActionListener(e -> {
            PlayerController playerFrame = new PlayerController();
            playerFrame.setVisible(true);
            dispose();
        });

        // 開啟道具管理視窗
        btnInventory.addActionListener(e -> {
            ItemController itemController = new ItemController();
            itemController.setVisible(true);
            dispose();
        });
	}

	
}
