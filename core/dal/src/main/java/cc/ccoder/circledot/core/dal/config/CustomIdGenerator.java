package cc.ccoder.circledot.core.dal.config;

import cc.ccoder.circledot.core.sequence.IdKey;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author: chencong
 * @date: 2019/12/20 11:12
 */
@Component
public class CustomIdGenerator implements IdentifierGenerator {


    @Autowired
    private IdGenerator idGenerator;

    @Override
    public Number nextId(Object entity) {
        return idGenerator.get(IdKey.SEQ_ID);
    }
}
