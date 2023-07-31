package org.sp.tproject.main.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import util.StringManager;

public class Timer extends JPanel implements Runnable {
	MainFrame mainFrame;
	private JLabel label;

	public Timer() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setBorder(new LineBorder(Color.WHITE, 1));
		
		String time = getCurrentTime();
		label = new JLabel(time);
		label.setFont(new Font("TimesRoman", Font.BOLD, 50));
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label, BorderLayout.CENTER);
		
		setPreferredSize(new Dimension(300,200));
		//setSize(300, 200);
		Thread t1 = new Thread(this);
		t1.start();

		setVisible(true);
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				String time = getCurrentTime();
				label.setText(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public String getCurrentTime() {
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int min = c.get(Calendar.MINUTE);
		int sec = c.get(Calendar.SECOND);

		String time = StringManager.getNumString(hour) + ":" + StringManager.getNumString(min) + ":" + StringManager.getNumString(sec);
		return time;
	}

	//public static void main(String[] args) {
	//	new Timer();

	//}

}


