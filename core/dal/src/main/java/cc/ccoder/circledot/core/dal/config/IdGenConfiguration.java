package cc.ccoder.circledot.core.dal.config;

import cc.ccoder.circledot.core.sequence.IDGen;
import cc.ccoder.circledot.core.sequence.segment.SegmentIDGenImpl;
import cc.ccoder.circledot.core.sequence.segment.dao.IDAllocDao;
import cc.ccoder.circledot.core.sequence.segment.dao.impl.IDAllocDaoImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author: chencong
 * @date: 2019/12/20 11:07
 */
@Configuration
public class IdGenConfiguration {


    /**
     * 使用默认数据源 在这里 DataSource默认不变
     *
     * @param dataSource datasource
     * @return IDAllocDao
     */
    @Bean
    public IDAllocDao idAllocDao(DataSource dataSource) {
        return new IDAllocDaoImpl(dataSource);
    }

    @Bean
    public IDGen idGen(IDAllocDao dao) {
        SegmentIDGenImpl result = new SegmentIDGenImpl();
        result.setDao(dao);
        return result;
    }

    @Bean
    @Qualifier("idGenerator")
    public IdGenerator idGenerator(IDGen gen) {
        return new IdGenerator(gen);
    }

}
