package databases;

import parser.Student;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import json.parser.CnnUtil;
/**
 * Created by mrahman on 04/02/18.
 */

public class ConnectToSqlDB {

    public static Connection connect = null;
    public static Statement statement = null;
    public static PreparedStatement ps = null;
    public static ResultSet resultSet = null;

    public static Properties loadProperties() throws IOException{
        Properties prop = new Properties();
        InputStream ism = new FileInputStream("src/secret.properties");
        prop.load(ism);
        ism.close();
        return prop;
    }

    public static Connection connectToSqlDatabase() throws IOException, SQLException, ClassNotFoundException {
        Properties prop = loadProperties();
        String driverClass = prop.getProperty("MYSQLJDBC.driver");
        String url = prop.getProperty("MYSQLJDBC.url");
        String userName = prop.getProperty("MYSQLJDBC.userName");
        String password = prop.getProperty("MYSQLJDBC.password");
        Class.forName("com.mysql.cj.jdbc.Driver");
        connect = DriverManager.getConnection(url,userName,password);
        System.out.println("Database is connected");
        return connect;
    }

    public List<String> readDataBase(String tableName, String columnName)throws Exception{
        List<String> data = new ArrayList<String>();

        try {
            connectToSqlDatabase();
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from " + tableName);
            data = getResultSetData(resultSet, columnName);
        } catch (ClassNotFoundException e) {
            throw e;
        }finally{
            close();
        }
        return data;
    }

    private void close() {
        try{
            if(resultSet != null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connect != null){
                connect.close();
            }
        }catch(Exception e){

        }
    }

    private List<String> getResultSetData(ResultSet resultSet2, String columnName) throws SQLException {
        List<String> dataList = new ArrayList<String>();
        while(resultSet.next()){
            String itemName = resultSet.getString(columnName);
            dataList.add(itemName);
        }
        return dataList;
    }

    public void insertDataFromArrayToSqlTable(int [] ArrayData, String tableName, String columnName)
    {
        try {
            connectToSqlDatabase();
            ps = connect.prepareStatement("DROP TABLE IF EXISTS `"+tableName+"`;");
            ps.executeUpdate();
            ps = connect.prepareStatement("CREATE TABLE `"+tableName+"` (`ID` int(11) NOT NULL AUTO_INCREMENT,`SortingNumbers` bigint(20) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
            ps.executeUpdate();
            for(int n=0; n<ArrayData.length; n++){
                ps = connect.prepareStatement("INSERT INTO "+tableName+" ( "+columnName+" ) VALUES(?)");
                ps.setInt(1,ArrayData[n]);
                ps.executeUpdate();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertDataFromStringToSqlTable(String ArrayData, String tableName, String columnName)
    {
        try {
            connectToSqlDatabase();
            ps = connect.prepareStatement("INSERT INTO "+tableName+" ( "+columnName+" ) VALUES(?)");
            ps.setString(1,ArrayData);
            ps.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<String> directDatabaseQueryExecute(String passQuery,String dataColumn)throws Exception{
        List<String> data = new ArrayList<String>();

        try {
            connectToSqlDatabase();
            statement = connect.createStatement();
            resultSet = statement.executeQuery(passQuery);
            data = getResultSetData(resultSet, dataColumn);
        } catch (ClassNotFoundException e) {
            throw e;
        }finally{
            close();
        }
        return data;
    }

    public void insertDataFromArrayListToSqlTable(List<Student> list, String tableName, String columnName)
    {
        try {
            connectToSqlDatabase();
            ps = connect.prepareStatement("DROP TABLE IF EXISTS `"+tableName+"`;");
            ps.executeUpdate();
            ps = connect.prepareStatement("CREATE TABLE `"+tableName+"` (`ID` int(11) NOT NULL AUTO_INCREMENT,`SortingNumbers` bigint(20) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
            ps.executeUpdate();
            for(Student st:list){
                ps = connect.prepareStatement("INSERT INTO "+tableName+" ( "+columnName+" ) VALUES(?)");
                ps.setObject(1,st);
                ps.executeUpdate();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertDataFromHelpListToSqlTable(List<CnnUtil> list, String tableName, String columnName)
    {
        try {
            connectToSqlDatabase();
            ps = connect.prepareStatement("DROP TABLE IF EXISTS `"+tableName+"`;");
            ps.executeUpdate();
            ps = connect.prepareStatement("CREATE TABLE `"+tableName+"` (`source` VARCHAR(5000) ,`author` VARCHAR(5000) DEFAULT NULL, `title` VARCHAR(5000) DEFAULT NULL,`url` LONGTEXT,`description` LONGTEXT,`urlToImage` LONGTEXT,`publisherAt` LONGTEXT ,`content` LONGTEXT  );");
            ps.executeUpdate();
            for(CnnUtil st:list){
                ps = connect.prepareStatement("INSERT INTO "+tableName+" ( "+"source,author,title,description,url,urlToImage,publisherAt,content"+" ) VALUES(?,?,?,?,?,?,?,?)");
                ps.setObject(1,st.getSource());
                ps.setObject(2,st.getAuthor());
                ps.setObject(3,st.getTitle());
                ps.setObject(4,st.getDescription());
                ps.setObject(5,st.getUrl());
                ps.setObject(6,st.getUrlToImage());
                ps.setObject(7,st.getPublisherAt());
                ps.setObject(8,st.getContent());


                ps.executeUpdate();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void insertDataFromStListToSqlTable(List<Student> list, String tableName, String columnName)
    {
        try {
            connectToSqlDatabase();
            ps = connect.prepareStatement("DROP TABLE IF EXISTS `"+tableName+"`;");
            ps.executeUpdate();
            ps = connect.prepareStatement("CREATE TABLE `"+tableName+"` (`firstName` VARCHAR(5000) ,`lastName` VARCHAR(5000) DEFAULT NULL, `score` VARCHAR(5000) DEFAULT NULL,`id` LONGTEXT );");
            ps.executeUpdate();
            for(Student st:list){
                ps = connect.prepareStatement("INSERT INTO "+tableName+" ( "+"firstName,lastName,score,id"+" ) VALUES(?,?,?,?)");
               ps.setObject(1,st.getFirstName());
                ps.setObject(2,st.getLastName());
                ps.setObject(3,st.getScore());
                ps.setObject(4,st.getId());
                ps.executeUpdate();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void insertProfileToSqlTable(String tableName, String columnName1, String columnName2)
    {
        try {
            connectToSqlDatabase();
                ps = connect.prepareStatement("INSERT INTO "+tableName+" ( " + columnName1 + "," + columnName2 + " ) VALUES(?,?)");
                ps.setString(1,"Abiral");
                ps.setInt(2,3590);
                ps.executeUpdate();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<CnnUtil> newReadListFromSqlDB(List<CnnUtil> newsList, String tablename)
    throws IOException, SQLException, ClassNotFoundException{
        List<CnnUtil> list = new ArrayList<CnnUtil>();
        CnnUtil news = new CnnUtil();
        Connection conn = connectToSqlDatabase();
        try{

            String query = "SELECT * FROM "+tablename;
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            // iterate through the java resultset
            while (rs.next())
            {


                String authorName = rs.getString("author");
                news.setAuthor(authorName);
                String title = rs.getString("title");
                news.setTitle(authorName);
                String description = rs.getString("description");
                news.setDescription(authorName);
                String url = rs.getString("url");
                news.setUrl(authorName);
                String urlToImage = rs.getString("urlToImage");
                news.setUrlToImage(urlToImage);

                String publisherAt = rs.getString("publisherAt");
                news.setPublisherAt(publisherAt);

                String content = rs.getString("content");
                news.setContent(content);


                list.add(news);



            }
            st.close();
        }catch (Exception e){
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        return list;
    }



    public List<Student> readStudentListFromSqlDB(String tablename){





        List<Student> list = new ArrayList<Student>();
        Student student = new Student();
        try{
            Connection conn = connectToSqlDatabase();
            String query = "SELECT * FROM "+tablename;
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            // iterate through the java resultset
            while (rs.next())
            {


                String firstName = rs.getString("firstName");
                student.setFirstName(firstName);
                String lastName = rs.getString("lastName");
                student.setLastName(lastName);
                int score = rs.getInt("score");
                student.setScore(score);
                String id = rs.getString("id");
                student.setId(id);
                student = new Student(student.getFirstName(),student.getLastName(),student.getScore(),student.getId());
                list.add(student);



            }
            st.close();
        }catch (Exception e){
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return list;

    }

    public static List<User> readUserProfileFromSqlTable()throws IOException, SQLException, ClassNotFoundException{
        List<User> list = new ArrayList<>();
        User user = null;
        try{
            Connection conn = connectToSqlDatabase();
            String query = "SELECT * FROM Students";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            // iterate through the java resultset
            while (rs.next())
            {
                String name = rs.getString("stName");
                String id = rs.getString("stID");
                String dob = rs.getString("stDOB");
                //System.out.format("%s, %s\n", name, id);
                user = new User(name,id, dob);
                list.add(user);

            }
            st.close();
        }catch (Exception e){
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return list;
    }

    public static void main(String[] args)throws IOException, SQLException, ClassNotFoundException {
        List<User> list = readUserProfileFromSqlTable();
        for(User user:list){
            System.out.println(user.getStName() + " " + user.getStID()+ " " + user.getStDOB());
        }
    }
}
