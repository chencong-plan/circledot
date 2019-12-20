package cc.ccoder.circledot.core.dal.config;

import cc.ccoder.circledot.core.sequence.IDGen;
import cc.ccoder.circledot.core.sequence.IdKey;
import cc.ccoder.circledot.core.sequence.common.SeqUtils;

/**
 * @author: chencong|cong.chen@42pay.com
 * @date: 2019/11/27 14:11
 */
public class IdGenerator implements IDGen {

    private final IDGen idGen;

    public IdGenerator(IDGen idGen) {
        this.idGen = idGen;
    }

    @Override
    public long get(String sequence) {
        long nextSequenceId = idGen.get(sequence);
        return SeqUtils.genSeqNoLong(nextSequenceId);
    }

    public long get(IdKey key) {
        return get(key.name());
    }

    public String getString(IdKey key) {
        return String.valueOf(get(key));
    }

}
