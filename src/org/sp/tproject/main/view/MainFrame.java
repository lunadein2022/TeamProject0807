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
	
	String[] naviImg= {}; //네비게이션 이미지경로 배열
	Page[] pages; //페이지 배열
	MainPage mainPage;
	//Timer timer;
	
	int width=1230;
	int height=800;
	
	public MainFrame() {
		p_north=new JPanel();
		p_content=new JPanel();
		mainPage=new MainPage();
		//timer=new Timer();
		
		//스타일
		p_north.setBackground(Color.DARK_GRAY);
		p_north.setPreferredSize(new Dimension(width, 50));
		p_content.setBackground(Color.WHITE);
		//p_content.setBorder(new LineBorder(Color.WHITE, 1));
		
		//조립
		p_content.add(mainPage);
		
		
		add(p_north, BorderLayout.NORTH);
		add(p_content);
		
		setSize(width, height);
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
