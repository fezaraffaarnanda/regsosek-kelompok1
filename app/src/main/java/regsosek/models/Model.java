package regsosek.models;

import java.sql.*;

/**
 *
 * @author FEZA
 */
public interface Model {
    /**
     * query db
     * @return 
     */
    public String getInsertStatement();

    public void prepareInsertStatement(PreparedStatement pstmt) throws SQLException;

    public void save() throws SQLException;
}