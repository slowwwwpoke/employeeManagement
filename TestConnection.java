public class TestConnection {
    public static void main(String[] args) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            if (conn != null) {
                System.out.println("Database connected successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
