package in.jdbc.connectionpool;

import org.postgresql.ds.PGPoolingDataSource;

public class ConnectionPool {
    public static void main(String[] args) {

        PGPoolingDataSource source = new PGPoolingDataSource();
        source.setDataSourceName("A Data Source");
        source.setServerNames(new String[]{
                "localhost"
        });
        source.setDatabaseName("test");
        source.setUser("testuser");
        source.setPassword("testpassword");
    }
}
