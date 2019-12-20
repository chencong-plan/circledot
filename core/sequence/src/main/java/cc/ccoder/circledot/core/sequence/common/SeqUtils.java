package cc.ccoder.circledot.core.sequence.common;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * @author: chencong
 * @date: 2019/12/20 10:47
 */
public class SeqUtils {

    /** 序列号长度 */
    public static int SEQ_NO_RIGHT_LEN = 9;

    private static final String DATE_PATTERN = "yyyyMMdd";

    /**
     * 返回前八后九的订单号，规则：8位日期+9位序列
     *
     * @param nextSequenceId
     *            序列值
     * @return 17位订单号
     */
    public static long genSeqNoLong(long nextSequenceId) {
        return Long.parseLong(genSeqNo(nextSequenceId));
    }

    /**
     * 返回前八后九的订单号，规则：8位日期+9位序列
     *
     * @param nextSequenceId
     *            序列值
     * @return 17位订单号
     */
    public static String genSeqNo(long nextSequenceId) {
        String date = DateFormatUtils.format(new Date(), DATE_PATTERN);
        String nextSeq = String.format("%09d", nextSequenceId);
        String seq = StringUtils.substring(nextSeq, nextSeq.length() - SEQ_NO_RIGHT_LEN);
        return date + seq;
    }

}