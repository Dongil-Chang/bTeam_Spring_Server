package iot;

import java.util.List;

public interface IoTService {

	void IoT_insert_TemHum(IoTVO vo);	// 온습도 값 저장 (C)
	List<IoTVO> IoT_list();	// 온습도 값 조회 (R)
}
