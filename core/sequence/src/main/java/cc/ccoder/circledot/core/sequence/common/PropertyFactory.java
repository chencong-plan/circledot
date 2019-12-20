package cc.ccoder.circledot.core.sequence.common;


import java.io.IOException;
import java.util.Properties;

/**
 * @author: chencong
 * @date: 2019/12/20 10:44
 */
public class PropertyFactory {
    private static final Properties prop = new Properties();

    static {
        try {
            prop.load(PropertyFactory.class.getClassLoader().getResourceAsStream("leaf.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties getProperties() {
        return prop;
    }
}

