package manager;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import member.MemberVO;

@Repository
public class ManagerDAO implements ManagerService {

	@Autowired private SqlSession sql; 
	
	@Override
	public List<MemberVO> member_list() {
		return sql.selectList("manager.mapper.member_list");
	}

	@Override
	public void provision_insert(ProvisionVO vo) {
		sql.insert("manager.mapper.provision_insert", vo);

	}

	@Override
	public List<ProvisionVO> provision_list() {
		return sql.selectList("manager.mapper.provision_list");
	}

	@Override
	public ProvisionVO provision_detail(String provision_code) {
		return sql.selectOne("manager.mapper.provision_detail", provision_code);
	}

	@Override
	public void provision_update(ProvisionVO vo) {
		sql.update("manager.mapper.provision_update", vo);
	}

	@Override
	public void provision_delete(String provision_code) {
		sql.delete("manager.mapper.provision_delete", provision_code);
	}

	@Override
	public void faq_insert(FaqVO vo) {
		sql.insert("manager.mapper.faq_insert", vo);
	}

	@Override
	public List<FaqVO> faq_list() {
		return sql.selectList("manager.mapper.faq_list");
	}

	@Override
	public FaqVO faq_detail(String faq_code) {
		return sql.selectOne("manager.mapper.faq_detail", faq_code);
	}

	@Override
	public void faq_update(FaqVO vo) {
		sql.update("manager.mapper.faq_update", vo);
	}

	@Override
	public void faq_delete(String faq_code) {
		sql.delete("manager.mapper.faq_delete", faq_code);
	}

}
