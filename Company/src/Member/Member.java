package Member;

public class Member {

	private String memberId;				// 아이디
	private String memberPw;				// 비밀번호
	private String memberName;				// 이름
	private String memberRole;				// 0 : 관리자, 1 : 학생
	private String memberTel;				// 전화번호
	private String memberSchoolName;		// 중학교 / 고등학교
	private int    grade;					// 학년
	

	// 생성자 없이 setter 사용해서 데이터 입력
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberRole() {
		return memberRole;
	}
	public void setMemberRole(String memberRole) {
		this.memberRole = memberRole;
	}
	public String getMemberTel() {
		return memberTel;
	}
	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}
	public String getMemberSchoolName() {
		return memberSchoolName;
	}
	public void setMemberSchoolName(String memberSchoolName) {
		this.memberSchoolName = memberSchoolName;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
}
