package com.api.users.dao;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import com.api.users.entities.Users;
import com.api.users.mappers.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UsersDAO {
    @Autowired
    private NamedParameterJdbcTemplate temp;
    @Autowired
    private UserMapper UserMapper;

    public List<Users> getAllUsers(){
        List<Users> list = temp.query("SELECT * FROM tbl_Users", UserMapper);
        return list;
    }

    public int createUser(int userId, String username, String password, int profileId, int employeeId, String status, Date createdDate, String login){
        return temp.update(
            "INSERT INTO tbl_Users (IdUser, UserName, uPassword, IdProfile, IdEmployee, Status, CreatedDate, Login) Values(:userId, :username, :password, :profileId, :employeeId, :status, :createdDate, :login)",
            new HashMap<String, Object>() {{
                put("userId", userId);
                put("username", username);
                put("password", password);
                put("profileId", profileId);
                put("employeeId", employeeId);
                put("status", status);
                put("createdDate", createdDate);
                put("login", login);
            }});
    }

    public int deleteUser(int userId){
        return temp.update("DELETE FROM tbl_Users WHERE IdUser = :userId", new HashMap<String, Object>() {{
            put("userId", userId);
        }});
    }

    public int updateUser(int userId, String username, String password, int profileId, int employeeId, String status, Date updatedDate, String login){
        return temp.update("UPDATE tbl_Users SET UserName = :username, uPassword = :password, IdProfile = :profileId, IdEmployee = :employeeId, Status = :status, UpdatedDate = :updatedDate WHERE IdUser = userId",
        new HashMap<String, Object>() {{
            put("username", username);
            put("password", password);
            put("profileId", profileId);
            put("employeeId", employeeId);
            put("status", status);
            put("updatedDate", updatedDate);
            put("login", login);
            put("userId", userId);
        }});
    }
}
