package contactus;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContactUsDAO implements ContactUsService {
	
	@Autowired private SqlSession sql;
	
	@Override
	public void cu_insert(ContactUsVO vo) {
		sql.insert("board.mapper.cu_insert", vo);
	}

	@Override
	public List<ContactUsVO> cu_list() {
		return sql.selectList("board.mapper.cu_list");
	}

	@Override
	public ContactUsVO cu_detail(int board_num) {
		return sql.selectOne("board.mapper.cu_detail", board_num);
	}

	@Override
	public void cu_update(ContactUsVO vo) {
		sql.update("board.mapper.cu_update", vo);
	}

	@Override
	public void cu_delete(int board_num) {
		// TODO Auto-generated method stub

	}

}
