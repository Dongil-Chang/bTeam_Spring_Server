package contactus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactUsServiceImpl implements ContactUsService {

	@Autowired private ContactUsDAO dao;
	
	@Override
	public void cu_insert(ContactUsVO vo) {
		dao.cu_insert(vo);
	}

	@Override
	public List<ContactUsVO> cu_list() {
		return dao.cu_list();
	}

	@Override
	public ContactUsVO cu_detail(int board_num) {
		return dao.cu_detail(board_num);
	}

	@Override
	public void cu_update(ContactUsVO vo) {
		dao.cu_update(vo);
	}

	@Override
	public void cu_delete(int board_num) {
		// TODO Auto-generated method stub

	}

}
