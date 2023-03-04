package dao;

import conexaojdbc.SingleConnection;
import model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private Connection connection;

    public UserDao() {
        connection = SingleConnection.getConnection();
    }


    public void insert(Users users) {
        try {
            String sql = "insert into usersjava (id, nome, email) values (?,?,?)";
            PreparedStatement insert = connection.prepareStatement(sql);
            insert.setLong(1, users.getId());
            insert.setString(2, users.getNome());
            insert.setString(3, users.getEmail());
            insert.execute();
            connection.setAutoCommit(false);
            //connection.commit();

        }catch ( Exception e) {

            try{
                connection.rollback();
                connection.setAutoCommit(false);

            }catch (Exception e2) {
                e2.printStackTrace();

            }

            e.printStackTrace();
        }
    }


    /*
    public List<Users> listar() throws Exception {
        List<Users> list = new ArrayList<>();

        String sql = "select * from usersjava";

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultado = statement.executeQuery();


        while (resultado.next()) {
            Users users = new Users();

            users.setId(resultado.getLong("id"));
            users.setNome(resultado.getString("nome"));
            users.setEmail(resultado.getString("email"));

            list.add(users);
        }
        return list;
    }
    public Users buscar(Long id) throws Exception {

        Users retorno = new Users();

        String sql = "select * from usersjava where id = "+ id;

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultado = statement.executeQuery();

        while (resultado.next()) {

            retorno.setId(resultado.getLong("id"));
            retorno.setNome(resultado.getString("nome"));
            retorno.setEmail(resultado.getString("email"));


        }
        return retorno;
    }*/

    public void update(Users users) {
        try {
            String sql = "UPDATE usersjava SET nome=?, email=? WHERE id=?";
            PreparedStatement update = connection.prepareStatement(sql);
            update.setString(1, users.getNome());
            update.setString(2, users.getEmail());
            update.setLong(3, users.getId());
            update.executeUpdate();

        }catch (Exception e) {
            try {
                connection.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        try {
            String sql = "DELETE FROM usersjava WHERE id = ?";

            PreparedStatement delete = connection.prepareStatement(sql);

            delete.setLong(1, id);
            delete.executeUpdate();

        }catch (Exception e3){
            try {
                connection.rollback();
            } catch (SQLException e1){
                e1.printStackTrace();
            }
            e3.printStackTrace();
        }
    }

}
