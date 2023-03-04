
import dao.UserDao;
import model.Users;
import org.junit.Test;

import java.util.List;

public class TesteBancoJdbc {

    @Test
    public void insertTest() {
        UserDao userDao = new UserDao();
        Users users = new Users();

        users.setId(9L);
        users.setNome("nomesfeios");
        users.setEmail("nomesfeios@test.com");

        userDao.insert(users);
    }

    /*
    @Test
    public void iniListar() {
        UserDao userDao = new UserDao();

        try {

            List<Users> list = userDao.listar();

            for (Users usersFor: list) {
                System.out.println(usersFor);
                System.out.println("_________________________________________________________________________");

            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void buscarTeste() {
        UserDao userDao = new UserDao();
        try {
            Users userscusc = userDao.buscar(6L);

            System.out.println(userscusc);
            System.out.println("_________________________________________________________________________");

        }catch (Exception e1){
            e1.printStackTrace();
        }

    }*/
    @Test
    public void updateTest() {

        try {
            UserDao userDao =new UserDao();
            Users users = new Users();
            users.setId(2L);
            users.setNome("Jefferson");
            users.setEmail("Jeffesoncarvalho10@gmail.com");

            userDao.update(users);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void deleteTest() {
        try {
            UserDao userdel = new UserDao();
            userdel.delete(1L);
            System.out.println("Delete execultado");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
