package gui_qlhd;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Tab {
	public static void createAndShowGUI() {

		// Create and set up the window.
		final JFrame frame = new JFrame("QUẢN LÝ");

		// Display the window.
                frame.setResizable(false);                
		frame.setSize(900, 550);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
		// set grid layout for the frame
		frame.getContentPane().setLayout(new GridLayout(1, 1));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		// add tab with title
		tabbedPane.addTab("Thêm hoá đơn", new TabAddBill());

		// add tab with title and icon
		Icon icon = new ImageIcon("icon.gif");
		tabbedPane.addTab("Danh sách hoá đơn", new TabListBill());

		// add tab with title, icon and tooltip
		String tooltip = "This is a tab";
		tabbedPane.addTab("Thống kê doanh thu theo tháng", new TabProfitMonth());

		frame.getContentPane().add(tabbedPane);

	}
}
