package Member;

import java.util.ArrayList;

import Co.common.DAO;

public class MemberDAO extends DAO {
	private static MemberDAO md = new MemberDAO();

	public static MemberDAO getInstance() {
		return md;
	}

	// 로그인 서비스
	public Member getLogin(String id, String pw) {
		Member member = null;
		try {
			conn();
			String sql = "select * from member where member_id = ? and member_pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String memberId = rs.getString("member_id");
				String memberPw = rs.getString("member_pw");
				String memberName = rs.getString("member_Name");
				String memberRole = rs.getString("role");
				String memberTel = rs.getString("member_tel");
				String memberSchoolName = rs.getString("school_Name");
				int grade = rs.getInt("grade");

				member = new Member();
				member.setMemberId(memberId);
				member.setMemberPw(memberPw);
				member.setMemberName(memberName);
				member.setMemberRole(memberRole);
				member.setMemberTel(memberTel);
				member.setMemberSchoolName(memberSchoolName);
				member.setGrade(grade);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return member;
	}

	public int insertMember(String id, String pw, String name, String role, String tel, String school, String grade) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO member (member_id, member_pw, member_name, role, Member_tel, school_name, grade) VALUES(?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, role);
			pstmt.setString(5, tel);
			pstmt.setString(6, school);
			pstmt.setString(7, grade);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

	// 전체 회원목록 조회
	public ArrayList<Member> getMemberList() {
		ArrayList<Member> members = new ArrayList<>();
		try {
			conn();
			String sql = "SELECT * FROM member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String memberId = rs.getString("member_id");
				String memberPw = rs.getString("member_pw");
				String memberName = rs.getString("member_Name");
				String memberRole = rs.getString("role");
				String memberTel = rs.getString("member_tel");
				String memberSchoolName = rs.getString("school_Name");
				int grade = rs.getInt("grade");

				Member member = new Member();
				member.setMemberId(memberId);
				member.setMemberPw(memberPw);
				member.setMemberName(memberName);
				member.setMemberRole(memberRole);
				member.setMemberTel(memberTel);
				member.setMemberSchoolName(memberSchoolName);
				member.setGrade(grade);

				members.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return members;
	}

	// 특정 회원 조회
	public Member getMember(String id) {
		Member member = null;
		try {
			conn();
			String sql = "SELECT * FROM member WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String memberId = rs.getString("member_id");
				String memberPw = rs.getString("member_pw");
				String memberName = rs.getString("member_Name");
				String memberRole = rs.getString("role");
				String memberTel = rs.getString("member_tel");
				String memberSchoolName = rs.getString("school_Name");
				int grade = rs.getInt("grade");

				member = new Member();
				member.setMemberId(memberId);
				member.setMemberPw(memberPw);
				member.setMemberName(memberName);
				member.setMemberRole(memberRole);
				member.setMemberTel(memberTel);
				member.setMemberSchoolName(memberSchoolName);
				member.setGrade(grade);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return member;
	}

	// 특정 회원 삭제
	public int deleteMember(String id) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM member WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

}