package org.sp.tproject.main.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

//메인에 배치될 컨텐츠들을 담을 페이지
//플레이어, 투두리스트 | 타이머, 프로그레스바 | 현재시간, 뽀모도로  
public class MainPage extends Page{
	JPanel p_west;
	JPanel p_center;
	JPanel p_east;
	
	CurrentTime ct;
	
	public MainPage() {
		p_west=new JPanel();
		p_center=new JPanel();
		p_east=new JPanel();
		
		ct=new CurrentTime();
		
		//스타일
		setLayout(new BorderLayout());
		
		Dimension d=new Dimension(400, 700);
		p_west.setPreferredSize(d);
		p_center.setPreferredSize(d);
		p_east.setPreferredSize(d);
		
		p_west.setBackground(Color.WHITE);
		p_west.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		p_center.setBackground(Color.WHITE);
		p_center.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		p_east.setBackground(Color.WHITE);
		p_east.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		
		//조립
		p_east.add(ct);
		
		add(p_west, BorderLayout.WEST);
		add(p_center);
		add(p_east, BorderLayout.EAST);
		
	}
}
