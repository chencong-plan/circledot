package cc.ccoder.circledot.core.sequence.segment.dao;

import cc.ccoder.circledot.core.sequence.segment.model.LeafAlloc;

import java.util.List;

/**
 * @author: chencong
 * @date: 2019/12/20 10:55
 */
public interface IDAllocDao {
    List<LeafAlloc> getAllLeafAllocs();
    LeafAlloc updateMaxIdAndGetLeafAlloc(String tag);
    LeafAlloc updateMaxIdByCustomStepAndGetLeafAlloc(LeafAlloc leafAlloc);
    List<String> getAllTags();
}