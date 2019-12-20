package cc.ccoder.circledot.core.sequence;

/**
 * @author: chencong
 * @date: 2019/12/20 10:50
 */
public interface IDGen {
    /**
     * 获取sequence 返回负数表示异常情况
     * @param sequence
     * @return
     */
    long get(String sequence);
}