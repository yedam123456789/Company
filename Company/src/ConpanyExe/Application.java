package ConpanyExe;

import java.util.Scanner;

import Board.BoardService;
import Lunch.LunchService;
import Member.Member;
import Member.MemberService;

public class Application {
	Scanner sc = new Scanner(System.in);

	// 회원관련 서비스 객체
	MemberService memberService = new MemberService();
	// 상품관련 서비스 객체
	LunchService lunchService = new LunchService();
	// 게시판관련 서비스 객체
	BoardService boardService = new BoardService();

	public Application() {
		run();
	}

	private void run() {

		while (true) {
			System.out.println("=======================");
			System.out.println("도시락 신청 관리 서비스입니다.");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 종료");
			System.out.println("=======================");

			int menuNo = Integer.parseInt(sc.nextLine());
			if (menuNo == 1) {
				// 로그인 성공여부
				Member member = loginService();
				if (member == null) {
					System.out.println("로그인에 실패하였습니다");
				} else {
					String role = member.getMemberRole().equals("0") ? "관리자" : "일반";
					System.out.println("로그인에 성공하였습니다(" + role + " " + member.getMemberName() + ")");
					// 로그인 성공 시 관리자/일반 구분
					// 관리자
					if (member.getMemberRole().equals("0")) {
						managerService();
					}
					// 일반
					else {
						normalService();
					}
				}

			}
			// 회원가입
			else if (menuNo == 2) {
				insertMember();
			} else if (menuNo == 3) {
				System.out.println("도시락 서비스를 종료하였습니다.");
				break;
			} else {
				System.out.println("1 ~ 3 메뉴를 선택해주세요.");
			}

		}

	}

	// 로그인 서비스
	private Member loginService() {
		System.out.println("ID를 입력해주세요 : ");
		String id = sc.nextLine();
		System.out.println("PW를 입력해주세요 : ");
		String pw = sc.nextLine();

		Member member = memberService.login(id, pw);
		return member;
	}

	// 회원가입 서비스
	private void insertMember() {
		System.out.println("ID를 입력해주세요 : ");
		String id = sc.nextLine();
		System.out.println("PW를 입력해주세요 : ");
		String pw = sc.nextLine();
		System.out.println("이름을 입력해주세요 : ");
		String name = sc.nextLine();
		System.out.println("권한을 입력해주세요(0:관리자, 1:일반) : ");
		String role = sc.nextLine();
		System.out.println("전화번호를 입력해주세요 : ");
		String tel = sc.nextLine();
		System.out.println("학교를 입력해주세요(중학교, 고등학교) : ");
		String school = sc.nextLine();
		System.out.println("학년를 입력해주세요(1, 2, 3) : ");
		String grade = sc.nextLine();

		memberService.insertMember(id, pw, name, role, tel, school, grade);
	}

	// 관리자 서비스
	private void managerService() {
		while (true) {
			System.out.println("관리자 기능");
			System.out.println("1.회원관리");
			System.out.println("2.상품관리");
			System.out.println("3.게시판관리");
			System.out.println("4.이전메뉴");
			int menuNo = Integer.parseInt(sc.nextLine());

			// 회원관리
			if (menuNo == 1) {
				memberManagement();
			}
			// 상품관리
			else if (menuNo == 2) {
				lunchManagement();
			}
			// 게시판관리
			else if (menuNo == 3) {
				boardManagement();
			}
			// 종료
			else if (menuNo == 4) {
				break;
			} else {
				System.out.println("1 ~ 4 메뉴를 선택해주세요.");
			}
		}
	}

	// 관리자 서비스 회원관리
	private void memberManagement() {
		while (true) {
			System.out.println("==========");
			System.out.println("회원관리 기능");
			System.out.println("1.회원조회");
			System.out.println("2.회원삭제");
			System.out.println("3.이전메뉴");
			System.out.println("==========");
			int menuNo = Integer.parseInt(sc.nextLine());
			// 전체 회원조회
			if (menuNo == 1) {
				memberService.getMemberList();
			}
			// 회원삭제
			else if (menuNo == 2) {
				System.out.print("삭제할 회원 아이디를 입력하세요 : ");
				String id = sc.nextLine();
				memberService.deleteMamber(id);
			}
			// 이전메뉴
			else if (menuNo == 3) {
				break;
			} else {
				System.out.println("1 ~ 3 메뉴를 선택해주세요.");
			}
		}

	}

	// 관리자 서비스 상품관리
	private void lunchManagement() {
		while (true) {
			System.out.println("==========");
			System.out.println("상품관리 기능");
			System.out.println("1.상품조회");
			System.out.println("2.상품등록");
			System.out.println("3.상품삭제");
			System.out.println("4.이전메뉴");
			System.out.println("==========");
			int menuNo = Integer.parseInt(sc.nextLine());

			// 상품조회
			if (menuNo == 1) {
				lunchService.getLunchList();
			}
			// 상품등록
			else if (menuNo == 2) {
				System.out.println("상품이름을 입력하세요 : ");
				String lunchName = sc.nextLine();
				System.out.println("상품가격을 입력하세요 : ");
				String lunchPrice = sc.nextLine();
				lunchService.insertLunch(lunchName, lunchPrice);
			}
			// 상품삭제
			else if (menuNo == 3) {
				System.out.println("상품이름을 입력하세요 : ");
				String lunchName = sc.nextLine();
				lunchService.deleteLunch(lunchName);
			}
			// 이전메뉴
			else if (menuNo == 4) {
				break;
			} else {
				System.out.println("1 ~ 4 메뉴를 선택해주세요.");
			}
		}
	}

	// 관리자 서비스 게시판관리
	private void boardManagement() {
		while (true) {
			System.out.println("==========");
			System.out.println("게시판관리 기능");
			System.out.println("1.게시판조회");
			System.out.println("2.게시판삭제");
			System.out.println("3.이전메뉴");
			System.out.println("==========");
			int menuNo = Integer.parseInt(sc.nextLine());
			// 게시판조회
			if (menuNo == 1) {
				boardService.getBoardList();
			}
			// 게시판삭제
			else if (menuNo == 2) {
				System.out.println("게시판 이름을 입력하세요 : ");
				String boardTitleName = sc.nextLine();
				boardService.deleteBoard(boardTitleName);
			}
			// 이전메뉴
			else if (menuNo == 3) {
				break;
			} else {
				System.out.println("1 ~ 3 메뉴를 선택해주세요.");
			}
		}

	}

	// 일반회원 서비스
	private void normalService() {
		while (true) {
			System.out.println("일반 기능");
			System.out.println("1.상품신청");
			System.out.println("2.게시판관리");
			System.out.println("3.이전메뉴");
			int menuNo = Integer.parseInt(sc.nextLine());

			// 상품신청
			if (menuNo == 1) {
				registerLunch();
			}
			// 게시판관리
			else if (menuNo == 2) {
				norMalBoardManagement();
			}
			// 이전메뉴
			else if (menuNo == 3) {
				break;
			} else {
				System.out.println("1 ~ 3 메뉴를 선택해주세요.");
			}
		}
	}

	// 도시락 신청
	private void registerLunch() {
		System.out.println("신청 가능한 도시락 목록입니다.");
		lunchService.getLunchList();

		System.out.println("신청할 도시락 과일 이름을 입력하세요");
		String name = sc.nextLine();
		lunchService.registerLunch(name);
	}

	// 게시판 관리
	private void norMalBoardManagement() {
		while (true) {
			System.out.println("==========");
			System.out.println("게시판관리 기능");
			System.out.println("1.게시판등록");
			System.out.println("2.게시판삭제");
			System.out.println("3.이전메뉴");
			System.out.println("==========");
			int menuNo = Integer.parseInt(sc.nextLine());
			// 게시판등록
			if (menuNo == 1) {
				System.out.println("게시판 이름을 입력하세요 : ");
				String boardTitle = sc.nextLine();
				System.out.println("게시판 내용을 입력하세요 : ");
				String boardContent = sc.nextLine();
				boardService.insertBoard(boardTitle, boardContent);
			}
			// 게시판삭제
			else if (menuNo == 2) {
				System.out.println("게시판 이름을 입력하세요 : ");
				String boardTitleName = sc.nextLine();
				boardService.deleteBoard(boardTitleName);
			}
			// 이전메뉴
			else if (menuNo == 3) {
				break;
			} else {
				System.out.println("1 ~ 3 메뉴를 선택해주세요.");
			}
		}

	}

}
