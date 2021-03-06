package com.xph.web.config.datasource;

import com.google.common.collect.Maps;

import javax.sql.DataSource;
import java.util.Map;

/**
 * Created by huipei.x on 2016/10/19 0019.
 */
public abstract class AbstractDataSourceConfig {

    /**
     * 属性前缀
     */
    protected static final String DB_DEFAULT_PREFIX = "spring.datasource.default";
    protected static final String DB_READ_PREFIX = "spring.datasource.read";
    protected static final String DB_WRITE_PREFIX = "spring.datasource.write";
    // 数据源
    protected abstract DataSource defaultDataSource();
    protected abstract DataSource readDataSource();
    protected abstract DataSource writeDataSource();

    public Map<Object,Object> getDataSourceMap(){
        Map<Object,Object> dataMap = Maps.newHashMap();

        dataMap.put(DbKey.DEFAULT, this.defaultDataSource());
        dataMap.put(DbKey.READ, this.readDataSource());
        dataMap.put(DbKey.WRITE, this.writeDataSource());

        DataSourceContextHolder.appendDbKey2Set(
                DbKey.DEFAULT,
                DbKey.READ,
                DbKey.WRITE
        );
        return dataMap;
    }
}
