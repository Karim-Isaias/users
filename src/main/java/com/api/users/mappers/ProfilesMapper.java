package com.api.users.mappers;

import com.api.users.entities.Profiles;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class ProfilesMapper implements RowMapper<Profiles> {
    
    @Override
    public Profiles mapRow(ResultSet result, int arg1) throws SQLException{
        Profiles obj = new Profiles();
        obj.setProfileId(result.getInt(1));
        obj.setProfile(result.getString(2));
        return obj;
    }
}
