package org.sp.tproject.main.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MainFrame extends JFrame{
	JPanel p_north; //네비게이션 영역
	JPanel p_content; //각 페이지 및 컨텐츠들이 배치될 메인 영역
	String[] naviImg= {};
	Page[] pages;
	
	Timer timer;
	
	
	public MainFrame() {
		p_north=new JPanel();
		p_content=new JPanel();
		
		//스타일
		p_north.setBackground(Color.BLACK);
		p_north.setPreferredSize(new Dimension(1200, 50));
		p_content.setBackground(Color.LIGHT_GRAY);
		p_content.setBorder(new LineBorder(Color.WHITE, 1));
		
		//조립
		add(p_north, BorderLayout.NORTH);
		add(p_content);
		
		timer=new Timer();
		p_content.add(timer);
		
		setSize(1200, 700);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void login() { //로그인 시 호출하는 메서드
		
	}
	public void logout() { //로그아웃 시 호출하는 메서드
		
	}
	
	public void showHide() { //페이지 전환처리 메서드
		
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
