package contactus;

import java.util.List;

public interface ContactUsService {
	void cu_insert(ContactUsVO vo); 		// 1:1 문의 신규 저장(C)
	List<ContactUsVO> cu_list();			// 1:1 문의 목록 조회(R)
	ContactUsVO cu_detail(int board_num);	// 1:1 문의 상세 내용 확인(R)
	void cu_update(ContactUsVO vo);			// 1:1 문의 내용 수정(U)
	void cu_delete(int board_num);			// 1:1 문의 내용 삭제(D)
}