/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericbillingsoftware;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author rohit
 */
public
        class SqlQueries {
    private static String curName,curEmail;
    private static String dbUrl = "jdbc:mysql://localhost:3306/javabillingsoftware", dbUsername = "root", dbPassword = "rohit";
    public final static int ITEM_TYPE=0, INT_TYPE=1, STRING_TYPE=2;
    public static String getUserName(String email)
    {
        try{
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from users where email='"+email+"';");
            if(!rs.next())
                throw new SQLException("User not found!");
            return rs.getString("name");
        }
        catch(SQLException error)
        {
            return null;
        }
    }
    public static String getUserType(String email)
    {
        try{
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from users where email='"+email+"';");
            if(!rs.next())
                throw new SQLException("User not found!");
            return rs.getString("account_type");
        }
        catch(SQLException error)
        {
            return null;
        }
    }
    public static Object[] getActiveItems(int type)
    {
        try{
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from items;");
            ArrayList<Object> res = new ArrayList<>();
            while(rs.next())
            {
                if(rs.getInt("active")==1)
                {
                    if(type==ITEM_TYPE)
                    {
                        res.add(new ItemObject(rs.getString("item_id"),rs.getString("item_name"),rs.getString("cost"),rs.getString("active")));
                    }
                    else if(type==INT_TYPE)
                    {
                        res.add(rs.getString("item_id"));
                    }
                    else if(type==STRING_TYPE)
                    {
                        res.add(rs.getString("item_name"));
                    }
                }
            }
            return res.toArray();
        }
        catch(SQLException error)
        {
            JLabel message = new JLabel(error.getMessage());
            message.setFont(new Font("Tahoma",0,18));
            JOptionPane.showMessageDialog(null, message);
            return null;
        }
    }
    public static Object[] getItems(int type)
    {
        try{
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from items;");
            ArrayList<Object> res = new ArrayList<>();
            while(rs.next())
            {
//                System.out.println("in sql: id->"+rs.getString("item_id")+",name->"+rs.getString("item_name")+",cost->"+rs.getString("cost")+",active->"+rs.getString("active"));
                if(type==ITEM_TYPE)
                {
                    res.add(new ItemObject(rs.getString("item_id"),rs.getString("item_name"),rs.getString("cost"),rs.getString("active")));
                }
                else if(type==INT_TYPE)
                {
                    res.add(rs.getString("item_id"));
                }
                else if(type==STRING_TYPE)
                {
                    res.add(rs.getString("item_name"));
                }
            }
            return res.toArray();
        }
        catch(SQLException error)
        {
            JLabel message = new JLabel(error.getMessage());
            message.setFont(new Font("Tahoma",0,18));
            JOptionPane.showMessageDialog(null, message);
            return null;
        }
    }
    public static String addItem(int item_id, String item_name, float cost, boolean active)
    {
        try{
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement stmnt = conn.createStatement();
            stmnt.executeUpdate("insert into items values("+item_id+",'"+item_name+"',"+cost+","+active+");");
            conn.close();
            return Boolean.toString(true);
        }
        catch(SQLException error)
        {
            return error.getMessage();
        }
    }
    public static ItemObject getItemFromID(String item_id)
    {
        try{
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from items where item_id="+item_id+";");
            if(!rs.next())
                throw new SQLException("Item Not Found!");
            return new ItemObject(rs.getString("item_id"),rs.getString("item_name"),rs.getString("cost"),rs.getString("active"));
        }
        catch(SQLException error)
        {
            return null;
        }
    }
    public static ItemObject getItemFromName(String item_name)
    {
        try{
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from items where item_name='"+item_name+"';");
            if(!rs.next())
                throw new SQLException("Item Not Found!");
            return new ItemObject(rs.getString("item_id"),rs.getString("item_name"),rs.getString("cost"),rs.getString("active"));
        }
        catch(SQLException error)
        {
            return null;
        }
    }
    public static String updateItem(String item_id, String item_name, String cost, String active, String old_id)
    {
        try{
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from items where item_id="+old_id+";");
            if(!rs.next())
                throw new SQLException("Item not found!");
            String sql = "update items set item_id="+item_id+",item_name='"+item_name+"',cost="+cost+",active="+active+" where item_id="+old_id+";";
            int affectedRows = stmnt.executeUpdate(sql);
            if(affectedRows!=1)
                throw new SQLException("Update failed!");
            conn.close();
            return Boolean.toString(true);
        }
        catch(SQLException error)
        {
            return error.getMessage();
        }
    }
    public static String delItem(int item_id)
    {
        try{
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement stmnt = conn.createStatement();
            stmnt.executeUpdate("delete from items where item_id="+item_id+";");
            conn.close();
            return Boolean.toString(true);
        }
        catch(SQLException error)
        {
            return error.getMessage();
        }
    }
    public static String delAccount(String email)
    {
        try{
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement stmnt = conn.createStatement();
            stmnt.executeUpdate("delete from users where email='" + email + "';");
            conn.close();
            return Boolean.toString(true);
        }
        catch(SQLException error)
        {
//            JOptionPane.showMessageDialog(null, error.getMessage());
            return error.getMessage();
        }
    }
    public static String addAccount(String name, String email, String password)
    {
        try{
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement stmnt = conn.createStatement();
            stmnt.executeUpdate("insert into users(name,email,password) values('" + name + "','" + email + "','" + password + "');");
            conn.close();
            return Boolean.toString(true);
        }
        catch(SQLException error)
        {
            return error.getMessage();
//            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }
    public static String changePassword(String email, String oldPassword, String newPassword)
    {
        try{
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from users where email='"+email+"';");
            rs.next();
            String oldPasswordInDB = rs.getString("password");
            if(!oldPassword.equals(oldPasswordInDB))
                throw new SQLException("Incorrect Old Password!");
            rs.close();
            stmnt.executeUpdate("update users set password='"+newPassword+"' where email='"+email+"';");
            conn.close();
            return Boolean.toString(true);
        }
        catch(SQLException error)
        {
            return error.getMessage();
        }
    }
    public static String changeEmail(String oldEmail, String password, String newEmail)
    {
        try{
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from users where email='"+oldEmail+"';");
            rs.next();
            String oldPasswordInDB = rs.getString("password");
            if(!password.equals(oldPasswordInDB))
                throw new SQLException("Incorrect Old Password");
            rs.close();
            stmnt.executeUpdate("update users set email='"+newEmail+"' where email='"+oldEmail+"';");
            conn.close();
            return Boolean.toString(true);
        }
        catch(SQLException error)
        {
            return error.getMessage();
        }
    }
    public static String changeName(String email, String password, String name)
    {
        try{
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from users where email='"+email+"';");
            rs.next();
            String oldPasswordInDB = rs.getString("password");
            if(!password.equals(oldPasswordInDB))
                throw new SQLException("Incorrect Old Password!");
            rs.close();
            stmnt.executeUpdate("update users set name='"+name+"' where email='"+email+"';");
            conn.close();
            return Boolean.toString(true);
        }
        catch(SQLException error)
        {
            return error.getMessage();
        }
    }
    public static String loginAccount(String email, String password)
    {
        try{
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from users where email='" + email + "';");
            if(!rs.next())
                throw new SQLException("Email Not Found");
            String name = rs.getString("name");
            String passwordInDB = rs.getString("password");
            if(!password.equals(passwordInDB))
                throw new SQLException("Passwords don't match");
            conn.close();
            return Boolean.toString(true);
        }
        catch(SQLException error)
        {
            return error.getMessage();
//            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }
    public static String updateCustomer(String phone,String newName, String newPhone, String newEmail)
    {
        try
        {
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement stmnt = conn.createStatement();
            stmnt.executeUpdate("UPDATE customers SET name='"+newName+"',email='"+newEmail+"',phone='"+newPhone+"' where phone='"+phone+"';");
            conn.close();
            return Boolean.toString(true);
        }
        catch(SQLException error)
        {
            return error.getMessage();
        }
    }
    public static String addCustomer(String name, String phone, String email)
    {
        try
        {
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement stmnt = conn.createStatement();
            stmnt.executeUpdate("INSERT INTO customers values('"+name+"','"+email+"','"+phone+"');");
            conn.close();
            return Boolean.toString(true);
        }
        catch(SQLException error)
        {
            return error.getMessage();
        }
    }
    public static ArrayList<String[]> getCustomers()
    {
        try
        {
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT * FROM customers;");
            ArrayList<String[]> temp = new ArrayList<>();
            while(rs.next())
            {
                String[] temp1 = new String[3];
                temp1[0] = rs.getString("name");
                temp1[1] = rs.getString("email");
                temp1[2] = rs.getString("phone");
                temp.add(temp1);
            }
            conn.close();
            return temp;
        }
        catch(SQLException error)
        {
            return null;
        }
    }
    public static String[] getCustomer(String phone)
    {
        try
        {
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT * FROM customers where phone='"+phone+"';");
            String[] temp1 = new String[3];
            if(rs.next())
            {
                temp1[0] = rs.getString("name");
                temp1[1] = rs.getString("email");
                temp1[2] = rs.getString("phone");
            }
            else
                throw new SQLException("Customer Not Found!");
            conn.close();
            return temp1;
        }
        catch(SQLException error)
        {
            return null;
        }
    }

    public static String getNextBillId()
    {
        try{
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery("select max(id)+1 as id from bills;");
            rs.next();
            if(rs.getString("id")!=null)
                return rs.getString("id");
            return "1";
        }
        catch(SQLException error)
        {
            return error.getMessage();
        }
    }
    
    public static String addBill(String bill_id, String location)
    {
        try{
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement stmnt = conn.createStatement();
            stmnt.executeUpdate("insert into bills values(" + bill_id + ",'" + location + "');");
            conn.close();
            return Boolean.toString(true);
        }
        catch(SQLException error)
        {
            return error.getMessage();
        }
    }
    
    public static
    String deleteBill(String cur_bill_id) {
        try{
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement stmnt = conn.createStatement();
            stmnt.executeUpdate("delete from bills where id=" + cur_bill_id + ";");
            conn.close();
            return Boolean.toString(true);
        }
        catch(SQLException error)
        {
            return error.getMessage();
        }
    }
    public static ArrayList<String[]> getBills()
    {
        try{
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from bills;");
            ArrayList<String[]> bills = new ArrayList<>();
            while(rs.next())
                bills.add(new String[]{rs.getString("id"), rs.getString("location")});
            conn.close();
            return bills;
        }
        catch(SQLException error)
        {
            return null;
        }
    }
}
