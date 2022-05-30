package Pack.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pack.vo.TestVo;
import Pack.vo.LogiMoveVo;

@Service
public class TestService {
    @Autowired
    public TestMapper mapper;

    public List<TestVo> selectTest() {
        return mapper.selectTest();
    }
    
    public List<LogiMoveVo> selectAll() {
        return mapper.selectAll();
    }
}
