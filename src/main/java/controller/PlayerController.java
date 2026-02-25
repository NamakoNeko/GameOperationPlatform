package controller;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Player;
import service.impl.PlayerServiceImpl;

public class PlayerController extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JTextArea textArea;

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
					PlayerController frame = new PlayerController();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	private PlayerServiceImpl service = new PlayerServiceImpl();

	/**
	 * Create the frame.
	 */
	public PlayerController()
	{
		setTitle("玩家管理");
		setSize(600, 500);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JLabel lblName = new JLabel("玩家名稱:");
		lblName.setBounds(30, 30, 100, 25);
		add(lblName);

		JTextField txtName = new JTextField();
		txtName.setBounds(120, 30, 150, 25);
		add(txtName);

		JButton btnAdd = new JButton("新增玩家");
		btnAdd.setBounds(300, 30, 120, 25);
		add(btnAdd);

		JButton btnQuery = new JButton("查詢全部");
		btnQuery.setBounds(430, 30, 120, 25);
		add(btnQuery);

		JButton btnDelete = new JButton("刪除(UID)");
		btnDelete.setBounds(30, 80, 120, 25);
		add(btnDelete);

		JTextField txtDeleteId = new JTextField();
		txtDeleteId.setBounds(160, 80, 100, 25);
		add(txtDeleteId);

		JButton btnUpdate = new JButton("修改等級");
		btnUpdate.setBounds(280, 80, 120, 25);
		add(btnUpdate);

		JTextField txtUpdateId = new JTextField();
		txtUpdateId.setBounds(410, 80, 60, 25);
		add(txtUpdateId);

		JTextField txtNewLevel = new JTextField();
		txtNewLevel.setBounds(480, 80, 60, 25);
		add(txtNewLevel);

		textArea = new JTextArea();
		textArea.setBounds(30, 130, 520, 250);
		add(textArea);

		JButton btnBack = new JButton("返回上一頁");
		btnBack.setBounds(230, 400, 150, 30);
		add(btnBack);

		// ===== 事件 =====

		btnAdd.addActionListener(e ->
		{
			try
			{
				service.addPlayer(txtName.getText());
				JOptionPane.showMessageDialog(this, "新增成功");
			} catch (Exception ex)
			{
				ex.printStackTrace();
			}
		});

		btnQuery.addActionListener(e -> loadPlayers());
		
		btnDelete.addActionListener(e ->
		{
			try
			{
				service.deletePlayer(txtDeleteId.getText());
				JOptionPane.showMessageDialog(this, "刪除成功");
			} catch (Exception ex)
			{
				ex.printStackTrace();
			}
		});
		
		btnUpdate.addActionListener(e ->
		{
			try
			{
				int level = 0;
				if (!txtNewLevel.getText().isEmpty())
				{
					level = Integer.parseInt(txtNewLevel.getText());
				}
				
				service.updateLevel(txtUpdateId.getText(), level);
				JOptionPane.showMessageDialog(this, "修改成功");
				
			} catch (Exception ex)
			{
				ex.printStackTrace();
			}
		});
		
		btnBack.addActionListener(e ->
		{
			AdminController adminController = new AdminController();
			adminController.setVisible(true);
			dispose();
		});
		
		txtNewLevel.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // 檢查是否為數字，若不是則消耗掉事件
                if (!Character.isDigit(c)) {
                    e.consume(); // 阻止輸入
                }
            }
        });
	}

	private void loadPlayers()
	{
		try
		{
			List<Player> list = service.findAll();
			textArea.setText("");
			for (Player p : list)
			{
				textArea.append("ID:" + p.getId() + " 名稱:" + p.getPlayerName() + " 等級:" + p.getLevel() + " 金幣:"
						+ p.getGold() + "\n");
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
