package org.sp.tproject.calendar.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.sp.tproject.main.view.Page;

import util.RoundedButton;

public class DiaryPage extends Page{
	JPanel p_north;
	JPanel p_west;
	JPanel p_center;
	JPanel p_east;
	RoundedButton bt_prev;
	RoundedButton bt_next;
	JLabel la_title;
	
	Calendar cal; //이전, 다음 버튼 등에 의해 조작될 날짜 객체
	int currentYear; //사용자가 보게 될 연도
	int currentMonth; //사용자가 보게될 월
	
	int width=1230;
	int height=800;
	
	//날짜 셀
	NumCell[][] numCells = new NumCell[6][7];
	
	public DiaryPage() {
		//UI 생성하기
		p_north = new JPanel();
		p_west = new JPanel();
		p_center = new JPanel();
		p_east = new JPanel();
		bt_prev = new RoundedButton("◀");
		bt_next = new RoundedButton("▶");
		la_title = new JLabel("2000-01-01");
		
		cal = Calendar.getInstance(); //날짜 객체 생성
		
		
		
		//스타일
		la_title.setFont(new Font("goyang", Font.BOLD, 45));
		
		p_west.setPreferredSize(new Dimension(150,750));
		p_center.setPreferredSize(new Dimension(800, 750));
		p_east.setPreferredSize(new Dimension(150, 750));
		
		
		
		//조립
		p_north.add(bt_prev);
		p_north.add(la_title);
		p_north.add(bt_next);
		
		
		
		add(p_north, BorderLayout.NORTH);
		add(p_west, BorderLayout.WEST);
		add(p_center);
		add(p_east, BorderLayout.EAST);
		
		createCell(); //셀 생성
		printTitle(); //달력 제목
		printNum(); //달력 날짜
		
		setSize(width, height);
		setVisible(true);

		
	}
	
	public void createCell() {
		
	}
	
	public void printTitle() {
		
	}
	
	public void printNum() {
		
	}
	
}




