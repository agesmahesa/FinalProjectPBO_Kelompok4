package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBHelper {
    private static final String CONN = "jdbc:sqlite:src\\Database\\DBFinalProject.db";

    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(CONN);
            createTable(conn);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Koneksi Gagal");
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conn;
    }

    public static void createTable(Connection conn) throws SQLException {
        String sqlCreate = "";
        sqlCreate = "CREATE TABLE IF NOT EXISTS individu (" +
                "    id_nasabah INT (15)     PRIMARY KEY" +
                "                            REFERENCES nasabah (id_nasabah) ON DELETE RESTRICT" +
                "                                                            ON UPDATE CASCADE," +
                "    nik        INTEGER (16)," +
                "    npwp       INTEGER (15) " +
                ");" +
                "CREATE TABLE IF NOT EXISTS nasabah (" +
                "    id_nasabah INT (15)      PRIMARY KEY," +
                "    nama       VARCHAR (100)," +
                "    alamat     VARCHAR (100) " +
                ");" +
                "CREATE TABLE IF NOT EXISTS perusahaan (" +
                "    id_nasabah INT (15)      PRIMARY KEY" +
                "                             REFERENCES nasabah (id_nasabah) ON DELETE RESTRICT" +
                "                                                             ON UPDATE CASCADE," +
                "    nib        VARCHAR (100) " +
                ");" +
                "CREATE TABLE IF NOT EXISTS rekening (" +
                "    no_rekening INT (10)       PRIMARY KEY," +
                "    saldo       DOUBLE (16, 2)," +
                "    id_nasabah  INT (15)       REFERENCES individu (id_nasabah) ON DELETE RESTRICT" +
                "                                                                ON UPDATE CASCADE" +
                ");";

        String sqls[] = sqlCreate.split(";");
            for (String sql : sqls) {
                PreparedStatement stet = conn.prepareStatement(sql);
                stet.execute();
            }
    }
}


