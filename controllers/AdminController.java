package com.bitcamp.controllers;
import javax.swing.JOptionPane;
public class AdminController {

	public static void main(String[] args) {
		while (true) {
			switch (JOptionPane.showInputDialog(("0.종료\n "
					+ "1. 회원가입\n"
					+ "2. 마이페이지\n"
					+ "3.비번수정\n"
					+ "4.회원탈퇴\n"
					+ "5.아이디존재체크\n"
					+ "6.로그인\n"
					+ "7.회원목록\n"
					+ "8.아이디검색\n"
					+ "9.이름검색"))) {
			case "0":
				
				break;

			default:
				break;
			}
			
		}

	}

}
