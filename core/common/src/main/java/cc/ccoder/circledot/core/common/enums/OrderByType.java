package cc.ccoder.circledot.core.common.enums;

/**
 * @author: chencong
 * @date: 2019/12/22 15:04
 */
public enum OrderByType {
    VIEW("view"),

    /**
     * 时间排序
     */
    TIME("time");

    public interface ORDER {
        String asc = "asc";
        String desc = "desc";
    }

    OrderByType(String code) {
        this.code = code;
    }

    private String code;

    public String getCode() {
        return code;
    }

    public static boolean checkIn(String code){
        for (OrderByType item : OrderByType.values()) {
            if(item.getCode().equals(code)){
                return true;
            }
        }
        return false;
    }
}
