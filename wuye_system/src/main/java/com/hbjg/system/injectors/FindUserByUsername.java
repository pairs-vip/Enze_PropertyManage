package com.hbjg.system.injectors;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

public class FindUserByUsername extends AbstractMethod {

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        String sqlMethod = "findUserByUsername";
        String sql = "select * from " + tableInfo.getTableName() + " where username = #{username}";
        SqlSource sqlSource = languageDriver.createSqlSource(configuration,sql,modelClass);
        return this.addSelectMappedStatementForTable(mapperClass,sqlMethod, sqlSource, tableInfo);
    }
}
