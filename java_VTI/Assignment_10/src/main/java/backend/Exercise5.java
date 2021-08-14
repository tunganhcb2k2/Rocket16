package backend;

import Utils.JDBCUtils;

import java.sql.SQLException;

public class Exercise5 {
    public void q1() throws SQLException, ClassNotFoundException {
        JDBCUtils.getConnection();
    }

    public void q3() throws SQLException {
        JDBCUtils.disConnection();
    }
}
