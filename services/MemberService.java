package com.bitcamp.services;
import com.bitcamp.domains.MemberBean;
public class MemberService {
	private MemberBean[] members;
	private int count;
	public MemberService() {
		members= new MemberBean[3];
		count= 0;
	}

	/*
	 * 요구사항(기능정의)
	 * <사용자기능
	 * 1. 회원가입
	 * 2.마이페이지
	 * 3.비번수정
	 * 4.회원탈퇴
	 * 5.아이디 존재 체크 
	 * 6.로그인
	 * ****
	 * <관리자기능
	 * 1. 회원목록
	 * 2.아이디검색
	 * 3.이름 검색 
	 * 4.전체 회원수*/
	/*******************************************
	 *사용자 기능 
	 ****************************************/
	/**
	/**
	 * 1. 회원가입
	 */
	public String join(MemberBean param) {
		String result = "회원가입성공";
		members[count]= param;
		count++;
	
		return result;
	}
	/**
	 * 2.마이페이지
	 */
	public String getMyPage(MemberBean param) {
		
		return param.toString();
	}
	/**
	 * 3.비번수정(ID 옛날비번 신규비번 입력받아서 옛날비번을 체크 후 일치하면 신규비번으로 변경 )
	 * 비번변경후 로그인 실행해서 새로바뀐 비번이 로그인 성공, 옛날 비번 로그인 실패 
	 */
	public String changePw(MemberBean param) {
		String result="비번변경";
		String id = param.getId();
		String pw = param.getPw();
		String[] pws = pw.split(",");
		String oPw =pws[0];
		String nPw =pws[1];
		
		
		for(int i=0;i<count;i++) {
			if(param.getId().equals(members[i].getId())
					&&pws[0].equals(members[i].getPw())) {
				members[i].setPw(nPw);
				
				break;				
			}
		}
		return result;
	}
	/**
	 * 4.회원탈퇴
	 */
	public String withDrawal(MemberBean param) {
		String result= "";
		return result;
	}
	/**
	 * 5.아이디 체크 
	 */
	public String existeId(String id) {
		String msg = "가입가능";
		for(int i=0;i<count;i++) {
			if(id.equals(members[i].getId())) {
				msg ="이미 존재하는 아이디";
				break;
			}
		}
		
		return msg;
	}
	/**
	 * 6.로그인 (파라미터로 아이디 비번만 입력받은 상황)
	 */
	public String login(MemberBean param) {
		String msg="실패";

		for(int i=0;i<count;i++) {
			if(param.getId().equals(members[i].getId())
					&&param.getPw().equals(members[i].getPw()))  {
				msg="로그인 성공";
				break;
			}
		}
		return msg;
	}
	
	/*******************************************
	 *관리자 
	 ****************************************/
	/**
	 * 1.회원목록
	 */
	public String list(MemberBean param) {
		String result="";
		for (int i=0;i<count;i++) {
			result +=members[i].toString()+"\n"
					+ "";
		}
		return result;
	}
	/**
	 * 2.아이디 검색
	 */
	public MemberBean findById(String id) {
		MemberBean member = new MemberBean();
		for(int i=0; i<count;i++) {
			if(id.equals(members[i].getId())) {
				member = members[i];
				break;
			}
		}
		return member;	
	}
	/**
	 * 3.이름검색
	 */
	public MemberBean[] findByName(String name) {
		int j =0;
		for (int i =0;i<count;i++) {
         	if (name.equals(this.members[i].getName())){
				 j ++;
			}
		}
		MemberBean[] members = new MemberBean[j];
		j=0;
		for(int i =0;i<count;i++) {
			if(name.equals(this.members[i].getName())) {
				members[j]= this.members[i];
				j++;
				if (members.length==j) {
					break;	
				}
				
				
			}members[i] = this.members[i];
		}

        return members;
	}
	public String countAll() {
		String num =String.valueOf(count);
		return num;
		//"총회원수 : "+count;
	}

}
