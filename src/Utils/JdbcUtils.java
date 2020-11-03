package Utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;

public class JdbcUtils {

    private static DataSource datasource;
    static{
        datasource = new ComboPooledDataSource();
    }

    public static QueryRunner getQueryRunner(){
        return new QueryRunner(datasource);
    }

    public static DataSource getDatasource() {
        return datasource;
    }
}
