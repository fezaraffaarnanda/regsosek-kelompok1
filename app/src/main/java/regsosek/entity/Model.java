package regsosek.entity;

import java.sql.*;

/**
 *
 * @author FEZA
 */
public interface Model {
    /**
     * Qury insert yang akan dibutuhkan oleh database.
     * @return 
     */
    public String getInsertStatement();

    /**
     * Mengisi data di prepared statement.
     * @param pstmt
     * @throws SQLException 
     */
    public void prepareInsertStatement(PreparedStatement pstmt) throws SQLException;

    /**
     * Memanggil database untuk menyimpan data.
     * @throws SQLException 
     */
    public void save() throws SQLException;
}
