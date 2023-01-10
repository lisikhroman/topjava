package ru.javawebinar.topjava;

import org.springframework.util.ClassUtils;

public class Profiles {
    public static final String
            JDBC = "jdbc",
            JPA = "jpa",
            DATAJPA = "datajpa";

    public static final String REPOSITORY_IMPLEMENTATION = DATAJPA;

    public static final String
        POSTGRES_DB = "postgres",
        HSQL_DB = "hsqldb",
        VDS = "vds";

    public static final String ACTIVE_DB = HSQL_DB;

    //  Get DB profile depending of DB driver in classpath
    //  Get DB profile depending on DB driver in classpath
    public static String getActiveDbProfile() {
        if (ClassUtils.isPresent("org.postgresql.Driver", null)) {
            return POSTGRES_DB;
        }
    }
}
