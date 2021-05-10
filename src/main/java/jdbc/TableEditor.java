package jdbc;

import java.sql.*;
import java.util.Properties;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("login"), properties.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName) {
        String query = "create table " + tableName + " (id serial primary key, name varchar(255);";
        executing(query);
    }

    public void dropTable(String tableName) {
        String query = "drop table " + tableName;
        executing(query);
    }

    public void addColumn(String tableName, String columnName, String type) {
        String query = "alter table " + tableName + " add column " + columnName + " "  + type;
        executing(query);
    }

    public void dropColumn(String tableName, String columnName) {
        String query = "alter table " + tableName + " drop column " + columnName ;
        executing(query);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        String query = "alter table " + tableName + " rename column " + columnName + " to "  + newColumnName;
        executing(query);
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    public void executing(String query) {
        try(Statement stat = connection.createStatement()) {
            stat.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}