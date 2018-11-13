package com.lee.dbslaveplugin.plugin;



import com.lee.dbslaveplugin.config.DataSourceHolder;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.keygen.SelectKeyGenerator;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Locale;
import java.util.Properties;

@Intercepts({@Signature(type = Executor.class,method = "update",args = {MappedStatement.class,Object.class})
,@Signature(type = Executor.class,method = "query",args = {MappedStatement.class,Object.class,RowBounds.class,ResultHandler.class})})
public class SQLPlugin implements Interceptor {
    private Logger logger=LoggerFactory.getLogger(SQLPlugin.class);
    private static final String REG=".*insert\\u0020.*|.*delete\\u0020.*|.*update\\u0020.*";
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //判断当前是否是事务
        boolean active = TransactionSynchronizationManager.isActualTransactionActive();
        String lookUpKey=null;
        //获取mybatis参数
        Object[] args = invocation.getArgs();
        MappedStatement ms=(MappedStatement)args[0];
        if (active!=true){

            //查询方法
            if(ms.getSqlCommandType().equals(SqlCommandType.SELECT)){
                //自增id查询主键
              if(ms.getId().contains(SelectKeyGenerator.SELECT_KEY_SUFFIX)){
                 lookUpKey=DataSourceHolder.MATSERDB;
              }else{
                  BoundSql boundSql = ms.getSqlSource().getBoundSql(args[1]);
                  String sql = boundSql.getSql().toLowerCase(Locale.CHINA).replaceAll("[\\t\\n\\r]"," ");
                  if(sql.matches(REG)){
                      lookUpKey=DataSourceHolder.MATSERDB;
                  }else{
                      lookUpKey=DataSourceHolder.SLAVEDB;
                  }
              }
            }else{
                lookUpKey=DataSourceHolder.MATSERDB;
            }
        }else{
            lookUpKey=DataSourceHolder.MATSERDB;
        }
        String info=String.format("设置方法%s,use %s Strategy,sqlCommandType %s",ms.getId()
        ,lookUpKey,ms.getSqlCommandType().name());
        logger.info(info);
        DataSourceHolder.setDbType(lookUpKey);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if(target instanceof Executor){
            return Plugin.wrap(target,this);
        }else{
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
