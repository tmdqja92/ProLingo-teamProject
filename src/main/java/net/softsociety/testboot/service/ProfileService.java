package net.softsociety.testboot.service;

import java.util.ArrayList;

import net.softsociety.testboot.domain.AchievementVO;

public interface ProfileService {
	
	/**
	 * 클리어한 업적 조회
	 * @return
	 */
	public ArrayList<AchievementVO> selectClear();
	
	/**
	 * 클리어 못한 업적 조회
	 * @return
	 */
	public ArrayList<AchievementVO> selectNotClear();
	
	

}