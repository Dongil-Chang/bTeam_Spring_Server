package iot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IoTServiceImpl implements IoTService {
	
	@Autowired private IoTDAO dao;
	
	@Override
	public void IoT_insert_TemHum(IoTVO vo) {
		dao.IoT_insert_TemHum(vo);
	}

	@Override
	public List<IoTVO> IoT_list() {
		return dao.IoT_list();
	}

	
}
