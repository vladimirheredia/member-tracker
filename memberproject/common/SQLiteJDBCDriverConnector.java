package memberproject.common;
import memberproject.models.Address;
import memberproject.models.Member;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLiteJDBCDriverConnector implements IDataProvider {

    /**
     * Connect to a sample database
     */
    private Connection connect() {
        Connection conn = null;
        try {
            // db parameters
            File urlPath = new File("resources/MemberTracker.sqlite");
            String url = "jdbc:sqlite:" + urlPath.getAbsolutePath();
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    /**
     * Create member in the DB
     * @param member
     */
    public void createMember(Member member){
        String sql = "INSERT INTO Members(FirstName, MiddleName, LastName, Age) VALUES(?,?,?,?)";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, member.getFirstName());
            pstmt.setString(2, member.getMiddleName());
            pstmt.setString(3, member.getLastName());
            pstmt.setInt(4, member.getAge());
            pstmt.executeUpdate();
            System.out.println("User added");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * select all rows in the warehouses table
     */
    public List<Member> getMembers(){
        String sql = "SELECT MEMBERS.ID, MEMBERS.FIRST_NAME, MEMBERS.MIDDLE_NAME, MEMBERS.LAST_NAME, MEMBERS.AGE, MEMBERS.IS_ACTIVE, MEMBERS.TELEPHONE, " +
        		     "ADDRESS.HOUSE_NUMBER, ADDRESS.STREET_NAME, ADDRESS.CITY, ADDRESS.STATE, ADDRESS.ZIP_CODE, MEMBER_TYPE.MEMBER_TYPE FROM MEMBERS " +
        		     "INNER JOIN ADDRESS ON MEMBERS.ADDRESS_ID = ADDRESS.ADDRESS_ID " +
        		     "INNER JOIN MEMBER_TYPE ON MEMBERS.MEMBER_TYPE_ID = MEMBER_TYPE.MEMBER_TYPE_ID;";

        List<Member> allMembers = new ArrayList<Member>();

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                Member m = new Member();
                Address a = new Address();
                //set address info
                a.setHouseNumber(rs.getInt("house_number"));
                a.setStreetName(rs.getString("street_name"));
                a.setCity(rs.getString("city"));
                a.setState(rs.getString("state"));
                a.setZipCode(rs.getString("zip_code"));
                
                //set member info
                m.setId(rs.getInt("ID"));
                m.setFirstName(rs.getString("First_Name"));
                m.setMiddleName(rs.getString("Middle_Name"));
                m.setLastName(rs.getString("Last_Name"));
                m.setAge(rs.getInt("Age"));
                m.setActive(rs.getBoolean("is_active"));
                m.setPhone(rs.getString("telephone"));
                m.setAddress(a);
                allMembers.add(m);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return allMembers;
    }

    /**
     * Update Member information
     * @param member
     */
    public void updateMember(Member member) {
        String sql = "UPDATE Members SET FirstName = ? , "
                     + "MiddleName = ? ,"
                     + "LastName = ? "
                     + "WHERE Id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, member.getFirstName());
            pstmt.setString(2, member.getMiddleName());
            pstmt.setString(3, member.getLastName());
            pstmt.setInt(4,4);

            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Delete Member in the DB
     * @param id
     */
    public void deleteMember(int id) {
        String sql = "DELETE FROM Members WHERE Id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Member getMemberById(int id) {
        String sql = "SELECT MEMBERS.ID, MEMBERS.FIRST_NAME, MEMBERS.MIDDLE_NAME, MEMBERS.LAST_NAME, MEMBERS.AGE, MEMBERS.IS_ACTIVE, MEMBERS.TELEPHONE, " +
        		     "ADDRESS.HOUSE_NUMBER, ADDRESS.STREET_NAME, ADDRESS.CITY, ADDRESS.STATE, ADDRESS.ZIP_CODE, MEMBER_TYPE.MEMBER_TYPE FROM MEMBERS " +
        		     "INNER JOIN ADDRESS ON MEMBERS.ADDRESS_ID = ADDRESS.ADDRESS_ID " +
        		     "INNER JOIN MEMBER_TYPE ON MEMBERS.MEMBER_TYPE_ID = MEMBER_TYPE.MEMBER_TYPE_ID WHERE Id = ?";
        Member m = null;
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	
        	
            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
            	 m = new Member();
                 Address a = new Address();
                 //set address info
                 a.setHouseNumber(rs.getInt("house_number"));
                 a.setStreetName(rs.getString("street_name"));
                 a.setCity(rs.getString("city"));
                 a.setState(rs.getString("state"));
                 a.setZipCode(rs.getString("zip_code"));
                 
                 //set member info
                 m.setId(rs.getInt("ID"));
                 m.setFirstName(rs.getString("First_Name"));
                 m.setMiddleName(rs.getString("Middle_Name"));
                 m.setLastName(rs.getString("Last_Name"));
                 m.setAge(rs.getInt("Age"));
                 m.setPhone(rs.getString("telephone"));
                 m.setActive(rs.getBoolean("is_active"));
                 
                 m.setAddress(a);
              
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return m;
    }
}
