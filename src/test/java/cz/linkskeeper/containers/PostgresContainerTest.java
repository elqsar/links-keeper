package cz.linkskeeper.containers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.testcontainers.containers.GenericContainer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class PostgresContainerTest {

    @ClassRule
    public static GenericContainer postgres = new GenericContainer("postgres:latest")
            .withExposedPorts(5432);

    @Before
    public void setUp() throws Exception {
        try {
            String postgresUrl = postgres.getContainerIpAddress() + ":" + postgres.getMappedPort(5432);
            String connectionUrl = "jdbc:postgresql://" + postgresUrl + "/testdb";
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(connectionUrl);

            Statement stmt = c.createStatement();
            String sql = "CREATE TABLE COMPANY " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " AGE            INT     NOT NULL, " +
                    " ADDRESS        CHAR(50), " +
                    " SALARY         REAL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }

    @Test
    public void sadTest() {
        Assert.assertEquals(false, true);
    }


}
