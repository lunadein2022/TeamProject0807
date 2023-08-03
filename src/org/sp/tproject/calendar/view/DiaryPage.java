package org.sp.tproject.calendar.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.sp.tproject.main.view.Page;

public class DiaryPage extends Page{
	JPanel p_north;
	JPanel p_west;
	JPanel p_center;
	JPanel p_east;
	JButton bt_prev;
	JButton bt_next;
	JLabel la_title;
	
	public DiaryPage() {
		//UI 생성하기
		p_north = new JPanel();
		p_west = new JPanel();
		p_center = new JPanel();
		p_east = new JPanel();
		bt_prev = new JButton();
		bt_next = new JButton();
		la_title = new JLabel();
		
		
	}
}




