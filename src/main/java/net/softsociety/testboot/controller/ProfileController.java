package net.softsociety.testboot.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.testboot.domain.AchievementVO;
import net.softsociety.testboot.domain.ContentsVO;
import net.softsociety.testboot.domain.MemberVO;
import net.softsociety.testboot.domain.MemberWeeklyExpVO;
import net.softsociety.testboot.service.MemberService;
import net.softsociety.testboot.service.ProfileService;

@Slf4j
@Controller
@RequestMapping("profile")
public class ProfileController {
	
	@Autowired
	ProfileService ps;
	
	@Autowired
	MemberService service;
	
	/**
	 * 
	 * @return profile page
	 */
	@GetMapping("")
	public String profile(Model model, @AuthenticationPrincipal UserDetails user) {
		//log.debug("called profile");
		// 현재 접속중인 유저의 userid를 조회
		String userId = user.getUsername();
				
		log.debug("접속중인 아이디: {}" , userId);
		// 달성한 업적 조회
		ArrayList<AchievementVO> clearList = ps.selectClear(userId);
		//log.debug("조회한 달성 리스트 전체 : {}", clearList);
		model.addAttribute("clearList", clearList);
		//요일별 경험치 조회
		//log.debug("데이터 조회 : {}",service.getExp(userId));
		//경험치 html로 날리기
		MemberWeeklyExpVO exp = service.getExp(userId);
		int mon_exp = exp.getMon_exp();
		int tue_exp = exp.getTue_exp();
		int wed_exp = exp.getWed_exp();
		int thu_exp = exp.getThu_exp();
		int fri_exp = exp.getFri_exp();
		int sat_exp = exp.getSat_exp();
		int sun_exp = exp.getSun_exp();
		
		model.addAttribute("mon", mon_exp);
		model.addAttribute("tue", tue_exp);
		model.addAttribute("wed", wed_exp);
		model.addAttribute("thu", thu_exp);
		model.addAttribute("fri", fri_exp);
		model.addAttribute("sat", sat_exp);
		model.addAttribute("sun", sun_exp);
		
		return "profile";
	}
	/**
	 * 업적 달성 페이지 및 업적 조회
	 * @return 업적 달성 
	 */
	@GetMapping("/achievements")
	public String achievements(Model model, @AuthenticationPrincipal UserDetails user) {
		
		// 현재 접속중인 유저의 userid를 조회
		String userId = user.getUsername();
		
		log.debug("접속중인 아이디: {}" , userId);
				
		// 달성한 업적 조회
		ArrayList<AchievementVO> clearList = ps.selectClear(userId);
		// 미달성한 업적 조회
		ArrayList<AchievementVO> notClearList = ps.selectNotClear(userId);
		
		//log.debug("조회한 달성 리스트 전체 : {}", clearList);
		//log.debug("조회한 미달성 리스트 전체 : {}", notClearList);
		
		model.addAttribute("clearList", clearList);
		model.addAttribute("notClearList", notClearList);
		
		return "profile/achievements";
	}
	/**
	 * 타임라인 페이지
	 * @return
	 */
	@GetMapping("/timelineTest")
	public String timelineTest() {
		log.debug("called timelineTest");
		return "profile/timelineTest";
	}
	
	/**
	 * 친구찾기 페이지 띄우기
	 */
	@GetMapping("/searchFriend")
	public String searchFriend() {
		return "profile/searchFriend";
	}
	
	/**
	 * 친구찾기 페이지 검색
	 */
	@GetMapping("/friendList")
	public ArrayList<MemberVO> friendList(String searchWord, @AuthenticationPrincipal UserDetails user) {
		
		log.debug("접속한 user : {}", user);
		
		String userId = user.getUsername();
		
		log.debug("검색어 : {}", searchWord); 
		
		//친구로 등록된 사람을 조회
		ArrayList<MemberVO> friendList = ps.searchfriends(searchWord, userId);
		
		log.debug("memberList: {}",friendList);
		
		return friendList;
	}
	
	
	
	/**
	 * 저장된 코드 페이지
	 */
	/*
	@GetMapping("/savedList")
	public String savedList() {
		log.debug("called savedList");
		return "profile/savedList";
	}
	*/
	
	/**
	 * 저장된 코드 페이지
	 */
	/*
	@GetMapping("/savedCode")
	public String savedCode() {
		log.debug("called savedCode");
		return "profile/savedCode";
	}
	*/
}
