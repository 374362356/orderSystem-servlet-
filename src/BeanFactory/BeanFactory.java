package BeanFactory;


//工厂：创建dao或service实例

import java.util.ResourceBundle;

public class BeanFactory {

    //加载配置文件
    private static ResourceBundle bundle;

    static {
        bundle = ResourceBundle.getBundle("instance");//配置文件名
    }

    public static <T> T getInstance(String key, Class<T> clas) {
        String classname = bundle.getString(key);
        try {
            return (T) Class.forName(classname).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
