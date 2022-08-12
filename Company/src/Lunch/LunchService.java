package Lunch;

import java.util.ArrayList;

import Member.Member;

public class LunchService {

	// 전체 상품조회 서비스
	public void getLunchList() {
		ArrayList<Lunch> lunchs = LunchDAO.getInstance().getLunchs();
		System.out.println("===상품정보===");
		System.out.println("총 " + lunchs.size() + "개");
		for(int i=0; i<lunchs.size(); i++) {
			Lunch lunch = lunchs.get(i);
			System.out.println(i+1 + ". " + lunch.getFruitName() + "|" + lunch.getFruitPrice() + "원" + "|" + lunch.getLunchBoxCount() +"개");
		}
	}

	public void registerLunch(String name) {
		Lunch lunch = LunchDAO.getInstance().getLunch(name);
		if(lunch == null) {
			System.out.println(name + " 상품은 없습니다.");	
		}
		else {
			int result = LunchDAO.getInstance().updateLunch(name, lunch.getLunchBoxCount());
			if(result == 0) {
				System.out.println(name + " 상품 등록에 실패하였습니다.");	
			}
			else {
				System.out.println(name + " 상품 등록에 성공하였습니다.");
			}
		}
	}

		
	
	// 상품등록 서비스
	public void insertLunch(String lunchName, String lunchPrice) {
		int result = LunchDAO.getInstance().insertLunch(lunchName, lunchPrice);
		if (result == 1) {
			System.out.println("상품 등록 성공");
		} 
		else {
			System.out.println("상품 등록 실패");
		}
	}

	// 상품삭제 서비스
	public void deleteLunch(String lunchName) {
		int result = LunchDAO.getInstance().deletelunch(lunchName);
		if (result == 1) {
			System.out.println("상품 삭제 성공");
		} 
		else {
			System.out.println("상품 삭제 실패");
		}
	}

}
