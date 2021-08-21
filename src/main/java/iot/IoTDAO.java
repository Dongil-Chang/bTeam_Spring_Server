package iot;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IoTDAO implements IoTService {

	@Autowired private SqlSession sql;
	
	@Override
	public void IoT_insert_TemHum(IoTVO vo) {
		sql.insert("iot.mapper.temhumInsert", vo);
	}

	@Override
	public List<IoTVO> IoT_list() {
		return sql.selectList("iot.mapper.temhumList");
	}

	
}
