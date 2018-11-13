package com.lee.dbslaveaop.config;

public class DataSourceHolder {

    private static ThreadLocal<String> threadLocal=new ThreadLocal<String>();
    public static final String MATSERDB="masterdb";
    public static final String SLAVEDB="slavedb";

    public static String getDbType(){
        String db = threadLocal.get();
        if(null==db){
            db=MATSERDB;
        }
        return db;
    }

    public static void setDbType(String dbType){
        threadLocal.set(dbType);
    }

    public static void clearDbType(){
        threadLocal.remove();
    }
}
