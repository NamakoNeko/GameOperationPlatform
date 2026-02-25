package controller;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import service.impl.ItemServiceImpl;

public class ItemController extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
					ItemController frame = new ItemController();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	private ItemServiceImpl service = new ItemServiceImpl();
	
	/**
	 * Create the frame.
	 */
	public ItemController()
	{
		setTitle("道具管理");
        setSize(450, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Player ID:");
        l1.setBounds(40, 40, 100, 25);
        add(l1);

        JTextField txtPlayerId = new JTextField();
        txtPlayerId.setBounds(140, 40, 180, 25);
        add(txtPlayerId);

        JLabel l2 = new JLabel("Item ID:");
        l2.setBounds(40, 90, 100, 25);
        add(l2);

        JTextField txtItemId = new JTextField();
        txtItemId.setBounds(140, 90, 180, 25);
        add(txtItemId);

        JLabel l3 = new JLabel("數量:");
        l3.setBounds(40, 140, 150, 25);
        add(l3);

        JTextField txtAmount = new JTextField();
        txtAmount.setBounds(190, 140, 130, 25);
        add(txtAmount);

        JButton btnSave = new JButton("新增 / 修改");
        btnSave.setBounds(140, 190, 150, 35);
        add(btnSave);

        JButton btnBack = new JButton("返回上一頁");
        btnBack.setBounds(140, 250, 150, 35);
        add(btnBack);
        
        // ===== 新增/修改道具 =====
        btnSave.addActionListener(e -> {
            try {
                int itemId = 0;
                Long amount = 0L;
                
                if (!txtItemId.getText().isEmpty())
                {
                		itemId = Integer.parseInt(txtItemId.getText());
                }
                
                if (!txtAmount.getText().isEmpty())
                {
                		amount = Long.parseLong(txtAmount.getText());
                }

                service.addOrUpdateItem(txtPlayerId.getText(), itemId, amount);

                JOptionPane.showMessageDialog(this, "操作成功");

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "發生錯誤");
            }
        });
        
        txtItemId.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // 檢查是否為數字，若不是則消耗掉事件
                if (!Character.isDigit(c)) {
                    e.consume(); // 阻止輸入
                }
            }
        });
        
        txtAmount.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // 檢查是否為數字，若不是則消耗掉事件
                if (!Character.isDigit(c)) {
                    e.consume(); // 阻止輸入
                }
            }
        });

        // ===== 返回上一頁 =====
        btnBack.addActionListener(e -> {
            new AdminController().setVisible(true);
            dispose();
        });
	}

}
