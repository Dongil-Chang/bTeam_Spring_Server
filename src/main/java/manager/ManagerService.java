package manager;

import java.util.List;

import member.MemberVO;

public interface ManagerService {
	
	List<MemberVO> member_list(); 	// 회원목록 조회 (R)
//	List<E> booking_list();			예약 리스트 조회 (R)
	
	
//	이용약관 페이지 작업	
	void provision_insert(ProvisionVO vo);	// 이용약관 저장 (C)
	List<ProvisionVO> provision_list(); 	// 이용약관 목록 조회(R)
	ProvisionVO provision_detail(String provision_code); // 이용약관 상세 조회(R)
	void provision_update(ProvisionVO vo);	// 이용약관 내용 수정 (U)
	void provision_delete(String provision_code);	// 이용약관 내용 삭제 (D)
	
//	FAQ 페이지 작업
	void faq_insert(FaqVO vo);			// Faq 저장 (C)
	List<FaqVO> faq_list();				// Faq 목록 조회(R)
	FaqVO faq_detail(String faq_code);	// Faq 상세 조회(R)
	void faq_update(FaqVO vo);			// Faq 내용 수정(U)
	void faq_delete(String faq_code);	// Faq 내용 삭제(D)
}
