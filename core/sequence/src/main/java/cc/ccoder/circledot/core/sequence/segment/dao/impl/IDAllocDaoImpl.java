package cc.ccoder.circledot.core.sequence.segment.dao.impl;

import cc.ccoder.circledot.core.sequence.segment.dao.IDAllocDao;
import cc.ccoder.circledot.core.sequence.segment.dao.IDAllocMapper;
import cc.ccoder.circledot.core.sequence.segment.model.LeafAlloc;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author: chencong
 * @date: 2019/12/20 10:57
 */
public class IDAllocDaoImpl implements IDAllocDao {

    SqlSessionFactory sqlSessionFactory;

    private String basePackage = "cc.ccoder.circledot.core.sequence.";

    public IDAllocDaoImpl(DataSource dataSource) {
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(IDAllocMapper.class);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }

    @Override
    public List<LeafAlloc> getAllLeafAllocs() {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        try {
            return sqlSession.selectList(basePackage + "segment.dao.IDAllocMapper.getAllLeafAllocs");
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public LeafAlloc updateMaxIdAndGetLeafAlloc(String tag) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.update(basePackage + "segment.dao.IDAllocMapper.updateMaxId", tag);
            LeafAlloc result = sqlSession.selectOne(basePackage + "segment.dao.IDAllocMapper.getLeafAlloc", tag);
            sqlSession.commit();
            return result;
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public LeafAlloc updateMaxIdByCustomStepAndGetLeafAlloc(LeafAlloc leafAlloc) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.update(basePackage + "segment.dao.IDAllocMapper.updateMaxIdByCustomStep", leafAlloc);
            LeafAlloc result = sqlSession.selectOne(basePackage + "segment.dao.IDAllocMapper.getLeafAlloc", leafAlloc.getKey());
            sqlSession.commit();
            return result;
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<String> getAllTags() {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        try {
            return sqlSession.selectList(basePackage + "segment.dao.IDAllocMapper.getAllTags");
        } finally {
            sqlSession.close();
        }
    }

}
