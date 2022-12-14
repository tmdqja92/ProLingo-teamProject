package net.softsociety.testboot.service;

import java.util.ArrayList;

import net.softsociety.testboot.domain.MemberVO;
import net.softsociety.testboot.domain.MemberWeeklyExpVO;

public interface MemberService {
	// 회원 등록
	public int insertMember(MemberVO member);

	// AJAX 로그인 체크
	public int logincheck(String email, String user_pw);

	// 회원 조회
	public MemberVO getMemerInfo(String userid);

	// 회원정보 수정
	public int updateMemberInfo(MemberVO member);

	// 회원탈퇴
	public int deleteAccont(String userid, String user_pw);

	// 유저 경험치 추가
	public int updateUserExp(String userid, int exp);

	// 유저 요일별 획득 누적 경험치
	public int updateUserExpDay(String username, int exp);

	// 유저 요일별 획득 누적 경험치 조회
	public MemberWeeklyExpVO getExp(String userid);

	public int isQuestionCompleted(String userid, int question_id);

	public int questionComplite(String userid, int question_id);

	public int updateDate(String userid);

	public ArrayList<MemberVO> selectAllUsers();

}
