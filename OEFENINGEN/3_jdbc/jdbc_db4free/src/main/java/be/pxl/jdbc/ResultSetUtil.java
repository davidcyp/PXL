package be.pxl.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultSetUtil {

    public static List mapStringFieldtToCollection(ResultSet rs, String columnName) throws SQLException {
        List result = new ArrayList();
        while (rs.next()) {
            result.add(rs.getString(columnName));
        }
        return result;
    }
}
