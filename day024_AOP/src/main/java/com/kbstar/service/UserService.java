package com.kbstar.service;

import com.kbstar.dao.UserDAO;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.MyDao;
import com.kbstar.frame.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service("uservice")

public class UserService implements MyService<String, UserDTO> {
    //주석처리된 Annotation으로 가능한 방법 한가지
    //@Autowired
    //@Qualifier("udao")
    //MyDao<String, UserDTO> dao;
    @Autowired
    UserDAO dao;


    @Override
    public void register(UserDTO userDTO) {
        dao.insert(userDTO);
        System.out.println("Send Mail");
    }

    @Override
    public void remove(String s) {
        dao.delete(s);
        System.out.println("Send Mail");
    }

    @Override
    public void modify(UserDTO userDTO) {
        dao.update(userDTO);
        System.out.println("Send Mail");
    }

    @Override
    public UserDTO get(String s) {
        return dao.select(s);
    }

    @Override
    public List<UserDTO> get() {
        return dao.select();
    }
}
