package Member;

import java.util.ArrayList;

public class MemberService {
	public static Member memberInfo = null;

	// 로그인
	public Member login(String id, String pw) {
		Member member = MemberDAO.getInstance().getLogin(id, pw);
		return member;
	}

	// 회원가입
	public void insertMember(String id, String pw, String name, String role, String tel, String school, String grade) {
		int result = MemberDAO.getInstance().insertMember(id, pw, name, role, tel, school, grade);
		if (result == 1) {
			System.out.println("회원가입 성공");

		} else {
			System.out.println("회원가입 실패");
		}
	}

	// 전체 회원조회
	
	public void getMemberList() {
		ArrayList<Member> members = MemberDAO.getInstance().getMemberList();
		System.out.println("===회원정보===");
		System.out.println("총 " + members.size() + "명");
		for (int i = 0; i < members.size(); i++) {
			Member member = members.get(i);
			System.out.println(i + 1 + ". " + member.getMemberId());
		}
	}

	// 특정 회원삭제
	public void deleteMamber(String memid) {
		int result = MemberDAO.getInstance().deleteMember(memid);
		if (result == 1) {
			System.out.println(memid + "회원을 삭제하였습니다..");

		} else {
			System.out.println(memid + "회원 삭제에 실패하였습니다..");
		}

	}
}
