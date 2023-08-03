package org.sp.tproject.member.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.sp.tproject.calendar.domain.Client;
import org.sp.tproject.calendar.model.ClientDAO;

import util.DBManager;
import util.HashConverter;
import util.MailSender;

public class RegistForm extends JFrame{
	//이름, 아이디, 비밀번호, 비밀번호 확인, 닉네임, 이메일 주소, 가입하기(버튼)
	JPanel regist_p_name;
	JLabel regist_la_name;
	JTextField regist_t_name;
	
	JPanel regist_p_id;
	JLabel regist_la_id;
	JTextField regist_t_id;
	JButton regist_bt_id;	//아이디 중복확인 버튼
	
	JPanel regist_p_pass;
	JLabel regist_la_pass;
	JPasswordField regist_t_pass;
	
	JPanel regist_p_pass_check;
	JLabel regist_la_pass_check;
	JPasswordField regist_t_pass_check;
	JLabel regist_la_pass_check_info;	//빨간색으로 안내 메세지
	
	JPanel regist_p_nickname;
	JLabel regist_la_nickname;
	JTextField regist_t_nickname;
	JButton regist_bt_nickname;
	
	JPanel regist_p_email;
	JLabel regist_la_email;
	JTextField regist_t_email;
	JLabel regist_la_email_link;
	JComboBox regist_t_email_domain;
	
	
	JButton regist_bt;	//가입 버튼
	
	//DB 관련
	DBManager dbManager;
	ClientDAO clientDAO;
	HashConverter hashConverter;	//비번
	MailSender mailSender;	//메일	

	
	

	public RegistForm() {
		regist_p_name = new JPanel();
		regist_la_name = new JLabel("이름");
		regist_t_name = new JTextField();
		
		regist_p_id = new JPanel();
		regist_la_id = new JLabel("아이디");
		regist_t_id = new JTextField();
		regist_bt_id =new JButton("중복확인");
		
		regist_p_pass = new JPanel();
		regist_la_pass = new JLabel("비밀번호");
		regist_t_pass = new JPasswordField();
		
		regist_p_pass_check = new JPanel();
		regist_la_pass_check = new JLabel("비밀번호 확인");
		regist_t_pass_check = new JPasswordField();
		regist_la_pass_check_info = new JLabel("비밀번호를 확인하세요");
		
		regist_p_nickname = new JPanel();
		regist_la_nickname = new JLabel("닉네임");
		regist_t_nickname = new JTextField();
		regist_bt_nickname = new JButton("중복확인");
		
		regist_la_email = new JLabel();
		
		regist_p_email = new JPanel();
		regist_t_email = new JTextField("이메일을 입력하세요");
		regist_la_email_link = new JLabel("@");
		regist_t_email_domain = new JComboBox();
		
		//DB 관련
		dbManager = new DBManager();
		clientDAO = new ClientDAO(dbManager);
		//비밀번호 hash 필요
		hashConverter = new HashConverter();
		mailSender = new MailSender();
		
		
		//이메일 도메인 선택 박스
		regist_t_email_domain.addItem("선택하세요");
		regist_t_email_domain.addItem("google.com");
		regist_t_email_domain.addItem("naver.com");
		regist_t_email_domain.addItem("daum.net");
		
		regist_bt = new JButton("가입하기");
		//폰트
		Font regist_la_font = new Font("돋움", Font.PLAIN, 20);
		Font regist_bt_font = new Font("돋움", Font.BOLD, 20);
		Font regist_info_font = new Font("돋움", Font.BOLD, 18);
		regist_la_name.setFont(regist_la_font);
		regist_t_name.setFont(regist_la_font);
		regist_la_id.setFont(regist_la_font);
		regist_t_id.setFont(regist_la_font);
		regist_la_pass.setFont(regist_la_font);
		regist_t_pass.setFont(regist_la_font);
		regist_la_pass_check.setFont(regist_la_font);
		regist_t_pass_check.setFont(regist_la_font);
		regist_la_pass_check_info.setFont(regist_info_font);
		regist_la_pass_check_info.setForeground(Color.red);
		regist_la_nickname.setFont(regist_la_font);
		regist_t_nickname.setFont(regist_la_font);
		regist_t_email.setFont(regist_la_font);
		regist_la_email_link.setFont(regist_la_font);
		
		regist_t_email_domain.setFont(regist_la_font);
		
		regist_bt.setFont(regist_bt_font);
		
		//디자인
		setLayout(new FlowLayout());
		Dimension regist_panel_d = new Dimension(450,80);
		Dimension regist_label_d = new Dimension(150,50);
		Dimension regist_text_d = new Dimension(200,50);
		Dimension regist_info_d = new Dimension(200,30);
		regist_p_name.setPreferredSize(regist_panel_d);
		regist_p_name.setLayout(new FlowLayout(FlowLayout.LEFT));
		regist_p_name.setAlignmentX(LEFT_ALIGNMENT);
		regist_la_name.setPreferredSize(regist_label_d);
		regist_t_name.setPreferredSize(regist_text_d);
		
		regist_p_id.setPreferredSize(regist_panel_d);
		regist_p_id.setLayout(new FlowLayout(FlowLayout.LEFT));
		regist_la_id.setPreferredSize(regist_label_d);
		regist_t_id.setPreferredSize(regist_text_d);
		
		regist_p_pass.setPreferredSize(regist_panel_d);
		regist_p_pass.setLayout(new FlowLayout(FlowLayout.LEFT));
		regist_la_pass.setPreferredSize(regist_label_d);
		regist_t_pass.setPreferredSize(regist_text_d);
		
		regist_p_pass_check.setPreferredSize(regist_panel_d);
		regist_p_pass_check.setLayout(new FlowLayout(FlowLayout.LEFT));
		regist_la_pass_check.setPreferredSize(regist_label_d);
		regist_t_pass_check.setPreferredSize(regist_text_d);
		regist_la_pass_check_info.setPreferredSize(regist_info_d);
		
		regist_p_nickname.setPreferredSize(regist_panel_d);
		regist_p_nickname.setLayout(new FlowLayout(FlowLayout.LEFT));
		regist_la_nickname.setPreferredSize(regist_label_d);
		regist_t_nickname.setPreferredSize(regist_text_d);
		
		regist_p_email.setPreferredSize(regist_panel_d);
		regist_p_email.setLayout(new FlowLayout(FlowLayout.LEFT));
		regist_t_email.setPreferredSize(regist_text_d);
		regist_la_email_link.setPreferredSize(new Dimension(30,50));
		regist_t_email_domain.setPreferredSize(regist_text_d);
		
		regist_bt.setPreferredSize(regist_label_d);
		
		//조립
		add(regist_p_name);
		regist_p_name.add(regist_la_name);
		regist_p_name.add(regist_t_name);
		add(regist_p_id);
		regist_p_id.add(regist_la_id);
		regist_p_id.add(regist_t_id);
		regist_p_id.add(regist_bt_id);
		add(regist_p_pass);
		regist_p_pass.add(regist_la_pass);
		regist_p_pass.add(regist_t_pass);
		add(regist_p_pass_check);
		regist_p_pass_check.add(regist_la_pass_check);
		regist_p_pass_check.add(regist_t_pass_check);
		regist_p_pass_check.add(regist_la_pass_check_info);
		add(regist_p_nickname);
		regist_p_nickname.add(regist_la_nickname);
		regist_p_nickname.add(regist_t_nickname);
		regist_p_nickname.add(regist_bt_nickname);
		
		add(regist_p_email);
		regist_p_email.add(regist_t_email);
		regist_p_email.add(regist_la_email_link);
		regist_p_email.add(regist_t_email_domain);
		

		add(regist_bt);
		
		
		//전체 프레임 사이즈
		setSize(600,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		regist_bt.addActionListener((e)->{
			regist();
		});
	}
	public void regist() {
		//db에 가입한 사용자 정보 넣기
		//사용자가 입력한 입력폼의 내용을 1개의 DTO 에 담아서 insert 메서드 호출
		Client client = new Client();	//empty
		client.setName(regist_t_name.getText());
		client.setId(regist_t_id.getText());
		//비밀번호 대입
		client.setPass(hashConverter.convertToHash(new String(regist_t_pass.getPassword())));
		client.setNickname(regist_t_nickname.getText());
		String fullEmail = regist_t_email.getText();
		fullEmail += "@";
		fullEmail += (String)regist_t_email_domain.getSelectedItem();
		client.setEmail(fullEmail);
		System.out.println(fullEmail);
		
		int result = clientDAO.insert(client);	//insert 호출
		if(result > 0) {
			
			//이메일 추가
			boolean flag= mailSender.send(fullEmail , "가입축하", " 가입을 진심으로 축하드려요");
			if(flag) {
				JOptionPane.showMessageDialog(this, "가입완료");
			}

			System.out.println("가입 성공");
			
		}
		
	}

	public static void main(String[] args) {
		new RegistForm();
	}
}
