package cc.ccoder.circledot.core.dal;

import cc.ccoder.circledot.CircledotApplication;
import cc.ccoder.circledot.core.common.util.DateUtil;
import cc.ccoder.circledot.core.dal.config.IdGenerator;
import cc.ccoder.circledot.core.dal.entity.Article;
import cc.ccoder.circledot.core.dal.mapper.ArticleMapper;
import cc.ccoder.circledot.core.sequence.IdKey;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.util.DateUtils;

/**
 * @author: chencong
 * @date: 2019/12/20 13:16
 */

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CircledotApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArticleMapperTest {


    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private IdGenerator idGenerator;
    @Test
    public void insert() {
        log.info("id:{}",idGenerator.get(IdKey.SEQ_ID));
        Article article = new Article();
        article.setTitle("这是标题");
        article.setTitle("测试自动输入");
        article.setContent("这是内容");
        article.setSourceContent("这是内容");
        article.setGmtCreate(DateUtil.getCurrentTS());
        int insert = articleMapper.insert(article);
        log.info("insert:{}", insert);
    }

}
