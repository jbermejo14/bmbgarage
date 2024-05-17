package org.bmbgarage.dao;
import org.bmbgarage.domain.Client;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;
import java.util.List;

public interface ClientDao {

    @SqlQuery("SELECT * FROM clients")
    @UseRowMapper(org.bmbgarage.dao.ClientMapper.class)
    List<Client> getAllClients();

    @SqlQuery("SELECT * FROM clients WHERE id = ?")
    @UseRowMapper(org.bmbgarage.dao.ClientMapper.class)
    Client getClient(int id);

    @SqlQuery("SELECT * FROM clients WHERE username = ? AND userpassword = ?")
    @UseRowMapper(org.bmbgarage.dao.ClientMapper.class)
    Client getClient(String username, String userpassword);

    @SqlUpdate("INSERT INTO clients (username, email, phonenumber, userpassword, rol) VALUES (?, ?, ?, ?, ?)")
    int addClient(String username, String email, String phonenumber, String userpassword, String rol);

    @SqlUpdate("UPDATE clients SET username = ?, userpassword = ?, telephone = ? WHERE id = ?")
    int updateClient(String username, String userpassword, int telephone, int id);

    @SqlUpdate("DELETE FROM clients WHERE id = ?")
    int removeClient(int id);
}