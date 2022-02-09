package com.api.users.dao;

import com.api.users.mappers.ProfilesMapper;

import java.util.HashMap;
import java.util.List;

import com.api.users.entities.Profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ProfilesDAO {
    @Autowired
    NamedParameterJdbcTemplate temp;
    @Autowired
    ProfilesMapper ProfilesMapper;

    public List<Profiles> getAllProfiles(){
        List<Profiles> list = temp.query("SELECT * FROM tbl_Profiles", ProfilesMapper);
        return list;
    }

    public int createProfile(int profileId, String profile){
        return temp.update("INSERT INTO tbl_Profiles VALUES (:profileId, :profile)", 
        new HashMap<String, Object>() {{
            put("profileId", profileId);
            put("profile", profile);
        }});
    }

    public int deleteProfile(int profileId){
        return temp.update("DELETE FROM tbl_Profiles WHERE IdProfile = :profileId", new HashMap<String, Object>() {{ 
            put("profileId", profileId);
        }});
    }

    public int updateProfile(int profileId, String profile){
        return temp.update("UPDATE tbl_Profiles SET uProfile = :profile WHERE IdProfile = :profileId", new HashMap<String, Object>() {{
            put("profile", profile);
            put("profileId", profileId);
        }});
    }
}
