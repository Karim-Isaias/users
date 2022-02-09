package com.api.users.mappers;

import com.api.users.entities.Users;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements RowMapper<Users> {
    
    @Override
    public Users mapRow(ResultSet result, int arg1) throws SQLException
    {
        Users obj = new Users();
        obj.setUserId(result.getInt(1));
        obj.setUsername(result.getString(2));
        obj.setPassword(result.getString(3));
        obj.setProfileId(result.getInt(4));
        obj.setEmployeeId(result.getInt(5));
        obj.setStatus(result.getString(6));
        obj.setCreatedDate(result.getTimestamp(7));
        obj.setUpdatedDate(result.getTimestamp(8));
        obj.setLogin(result.getString(9));
        return obj;
    }
}
