package member;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO implements MemberService {

	@Autowired private SqlSession sql;
	@Override
	public boolean member_join(MemberVO vo) {
		return sql.insert("member.mapper.join_insert", vo) == 1 ? true : false;
	}

	@Override
	public MemberVO member_login(HashMap<String, String> map) {
		return sql.selectOne("member.mapper.login", map);
	}

	@Override
	   public boolean member_id_check(String id) {
	      return  (Integer) sql.selectOne("member.mapper.idchk", id) == 0 ? true : false;
	   }

	@Override
	public boolean member_update(MemberVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean member_delete(String id) {
		//int delete = sql.delete("member.mapper.delete", id);
		return (Integer)sql.delete("member.mapper.delete", id) == 1 ? true : false;
	}

	@Override
	public boolean member_social_email(MemberVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean member_social_insert(MemberVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean member_social_update(MemberVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MemberVO member_pw_check(String pw) {
		return sql.selectOne("member.mapper.pwchk", pw);
	}

}
