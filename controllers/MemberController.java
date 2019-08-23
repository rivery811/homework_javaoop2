package com.bitcamp.controllers;
import javax.swing.JOptionPane;
import com.bitcamp.domains.MemberBean;
import com.bitcamp.services.MemberService;
public class MemberController {

	public static void main(String[] args) {
		MemberService service = new MemberService();
		MemberBean member= null;
		String[]arr=null;
		String temp = "";
		while (true) {
			switch (JOptionPane.showInputDialog("0.종료\n "
					+ "1. 회원가입\n"
					+ "2. 마이페이지\n"
					+ "3.비번수정\n"
					+ "4.회원탈퇴\n"
					+ "5.아이디존재체크\n"
					+ "6.로그인\n"
					+ "7.회원목록\n"
					+ "8.아이디검색\n"
					+ "9.이름검색")) {
			case "0":
				JOptionPane.showMessageDialog(null, "종료");
				return;
			case "1":
				member = new MemberBean();
				String spec = JOptionPane.showInputDialog("이름,아이디,비번,주민번호,혈액형,키,몸무게");
				arr = spec.split(",");
				member.setName(arr[0]);
				member.setId(arr[1]);
				member.setPw(arr[2]);
				member.setSsn(arr[3]);
				member.setBlood(arr[4]);
				member.setHeight(Double.parseDouble(arr[5]));
				member.setWeight(Double.parseDouble(arr[6]));
				JOptionPane.showMessageDialog(null, service.join(member));
			
				break;
				
			case "2":
				JOptionPane.showMessageDialog(null, service.getMyPage(member));
				
				break;
			case "3":
				temp = JOptionPane.showInputDialog("아이디, 비밀번호 , 새 비밀번호");
				arr = temp.split(",");
		
				member = new MemberBean();
				member.setId(arr[0]);
				member.setPw(arr[1]+","+arr[2]);
				String ms = service.changePw(member);
				
				
				JOptionPane.showMessageDialog(null, service.changePw(member));
				break;
			case "4":
				JOptionPane.showMessageDialog(null, service.withDrawal(member));
				break;
			case "5":
				String searchEId=JOptionPane.showInputDialog("검색ID");
				JOptionPane.showMessageDialog(null, service.existeId(searchEId));
				break;
			case "6" :
				String loginValue = JOptionPane.showInputDialog("아이디,비밀번호");
				String [] loginValues = loginValue.split(",");
				String loginId = loginValues[0];
				String lohinPw= loginValues[1];
				member = new MemberBean();
				member.setId(loginId);
				member.setPw(lohinPw);
				String msg = service.login(member);
				JOptionPane.showMessageDialog(null, msg);
				
				break;
			case "7":
				JOptionPane.showMessageDialog(null, service.list(member));
				break;
				
				
			case "8":
				String searchId=JOptionPane.showInputDialog("검색ID");
				member=service.findById(searchId);
				JOptionPane.showMessageDialog(null, member);
				break;
			case "9" :
				String searchName = JOptionPane.showInputDialog("검색이름");
				JOptionPane.showMessageDialog(null, service.findByName(searchName));
				
				

			default:
				break;
			}
			
		}

	}

}
