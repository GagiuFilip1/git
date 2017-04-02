package com.codemonkeys.portal.monkeyData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Gagiu on 4/1/2017.
 */
public class MonkeyDataManager {
  private final String myDriver = "org.gjt.mm.mysql.Driver";
  private final String myUrl = "jdbc:mysql://192.168.0.107/test";

  public MonkeyDataManager()
  {

  }
  public int ReadUser(String user , String pass)
  {
    try
    {

      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "admin", "pass");

      String query = "SELECT * FROM `users`;";

      Statement st = conn.createStatement();

      ResultSet rs = st.executeQuery(query);

      while (rs.next())
      {
        String username = rs.getString("username");
        String password = rs.getString("Password");
        int type = rs.getInt("type");
        //System.out.println("in while " + username + " " + password);
        if(user.equals(username) && pass.equals(password)) {
          st.close();
          conn.close();
          return type;
        }
      }
      st.close();
      conn.close();
      return -1;
    }
    catch (Exception e)
    {
      System.out.println("noped");
      return  -1;
    }
  }
  public String ReadCol(String table, String coloana, String com)
  {
    String result = new String();
    try
    {
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "admin", "pass");

      String query = "SELECT `" + coloana + "` FROM `" + table + "`" + com + ";";

      Statement st = conn.createStatement();

      ResultSet rs = st.executeQuery(query);

      while (rs.next())
      {
        result = rs.getString(coloana);
        System.out.format("%s,\n", rs.getString(coloana));
      }
      st.close();
      conn.close();
      return result;
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
    return "";
  }
  public String[] Search(String data)
  {
    String[] mydata = new String[100];
    int contor = 0;
    try
    {
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "admin", "pass");


      String query = "SELECT * FROM `dateuser`;";

      Statement st = conn.createStatement();

      ResultSet rs = st.executeQuery(query);

      while (rs.next())
      {
        String id = rs.getString("id");
        String id_grupa = rs.getString("id_grupa");
        String nume = rs.getString("Nume");
        String prenume = rs.getString("Prenume");
        String telefon = rs.getString("Telefon");
        if(data.equals(id) || data.equals(nume) || data.equals(prenume) || data.equals(telefon))
        {
          mydata[contor] = id + ";" + id_grupa + ";" + nume + ";" + prenume + ";" + telefon + ";";
          contor = contor + 1;
        }
      }
      st.close();
      conn.close();
      return mydata;
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
      return null;
    }
  }
  public String[] ReadOrar(String data)
  {
    String[] mydata = new String[100];
    int contor = 0;
    try
    {
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "admin", "pass");


      String query = "SELECT * FROM `orar`;";

      Statement st = conn.createStatement();

      ResultSet rs = st.executeQuery(query);

      while (rs.next())
      {
        String id_curs = rs.getString("id_curs");
        String zi = rs.getString("zi");
        String ora_intrare = rs.getString("ora_intrare");
        if(data.equals(zi))
        {
          mydata[contor] = id_curs + ";" + ora_intrare + ";";
          contor = contor + 1;
        }
      }
      st.close();
      conn.close();
      return mydata;
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
      return null;
    }
  }
  public void UpdateUserPassword(String user, String old_password, String new_password)
  {
    String aux = ReadCol("users","password","WHERE `user` = " + user);
    if(aux == old_password)
      Update("UPDATE `users` SET `password`='" + new_password + "' WHERE `username` = '" + user + "';");
    else System.err.println("Nu-i Bun!");
  }
  public void UpdateUserType(String user, int type)
  {
    Update("UPDATE `users` SET `type`='" + type + "' WHERE `username` = '" + user + "';");
  }
  public void UpdateUsername(String old_user, String new_user)
  {
    Update("UPDATE `users` SET `username`='" + new_user + "' WHERE `username` = '" + old_user + "';");
  }
  public void UpdateDate(String table, String coloana, int id,String data)
  {
    Update("UPDATE `" + table + "` SET `" + coloana + "`='" + data + "' WHERE `id` = '" + id + "';");
  }
  public void UpdateGrupa(int id_grupa)
  {
    Update("UPDATE `dateuser` SET `id_grupa`='0' WHERE `id_grupa` = '" + id_grupa + "';");
  }
  private void Update(String comanda)
  {
    try
    {
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "admin", "pass");

      String query = comanda;//"UPDATE `users` SET `password`='" + password + "' WHERE `username` = '" + user + "';";

      PreparedStatement preparedStmt = conn.prepareStatement(query);

      preparedStmt.executeUpdate();

      conn.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
  }
  public void InsertUser(String user, String password, int type)
  {
    Insert("INSERT INTO `users` (`username`, `password`, `type`) VALUES ('" + user
        + "', '" + password + "', '" + type + "');");
  }
  public void InsertDate(int id, String nume, String prenume, String telefon, int id_grupa)
  {
    Insert("INSERT INTO `dateuser` (`id`, `id_grupa`, `Nume`, `Prenume`, `Telefon`) VALUES ('" + id + "', '"
        + id_grupa + "', '" + nume + "', '" + prenume + "', '" + telefon + "');");
  }
  public void InsertCurs(int id_prof, int id_grupa, String numecurs)
  {
    Insert("INSERT INTO `cursuri` (`id`, `Nume`, `id_profesor`, `id_grupa`) VALUES (NULL, '" + numecurs + "', '"
        + id_prof +"', '" + id_grupa + "');");
  }
  public void InsertGrupa(String nume, String specialitate)
  {
    Insert("INSERT INTO `grupe` (`id`, `Nume`, `Specialitate`) VALUES (NULL, '" + nume + "', '"
        + specialitate + "');");
  }
  public void InsertOrar(int id_curs,int ora_intrare,String zi)
  {
    Insert("INSERT INTO `orar` (`id`,`id_curs`, `zi`, `ora_intrare`) VALUES (NULL,'" + id_curs + "', '" + zi +
        "', '" + ora_intrare + "');");
  }
  public void InsertHash(String hash,boolean ok)
  {
    Insert("INSERT INTO `invitations` (`id`, `hash`, `val`) VALUES (NULL, '" + hash + "', '"
        + ok + "');");
  }
  private void Insert(String comanda)
  {
    try
    {
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "admin", "pass");

      String query = comanda;//"INSERT INTO `users` (`username`, `password`, `type`) VALUES ('" + user
      //+ "', '" + password + "', '" + type + "');";

      PreparedStatement preparedStmt = conn.prepareStatement(query);

      preparedStmt.executeUpdate();

      conn.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
  }
  public void Delete(String table,String conditie, String id)
  {
    try
    {
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "admin", "pass");

      String query = "DELETE FROM `" + table + "` WHERE `" + conditie + "` = '" + id + "';";

      PreparedStatement preparedStmt = conn.prepareStatement(query);

      preparedStmt.executeUpdate();
      preparedStmt = conn.prepareStatement("ALTER TABLE " + table + " AUTO_INCREMENT=0");
      preparedStmt.executeUpdate();
      conn.close();

      if (table.equals("users")) {
        Delete("dateuser", "id", id);

      } else if (table.equals("grupe")) {
        UpdateGrupa(Integer.parseInt(id));

      } else if (table.equals("cursuri")) {
        Delete("orar", "id_curs", id);

      }
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
  }
  public void ClearAllInfo(String table)
  {
    try
    {
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "admin", "pass");

      String query = "TRUNCATE TABLE `" + table + "`;";

      PreparedStatement preparedStmt = conn.prepareStatement(query);
      preparedStmt.executeUpdate();
      if (table.equals("users")) {
        ClearAllInfo("dateuser");

      //} //else if (table.equals("grupe")) {
        //UpdateGrupa(Integer.parseInt(id));

      } else if (table.equals("cursuri")) {
        ClearAllInfo("orar");

      }
      conn.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }

  }
}
