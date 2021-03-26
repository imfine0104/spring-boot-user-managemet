package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService{

    private static ArrayList<User> users = new ArrayList<User>();

    static {
        users.add(new User(1,"Nguyen Thi Mong Mo","mongmo@gmail.com","avatar.img","321"));
        users.add(new User(2,"Ajinomoto","Ajinomoto@gmail.com","avatar.img","123"));
        users.add(new User(3,"Oishi","Oishi@gmail.com","avatar.img","456"));
        users.add(new User(4,"Karai","Karai@gmail.com","avatar.img","654"));
    }

    @Override
    public List<UserDto> getAllUser() {
        List<UserDto> userDtos = new ArrayList<UserDto>();
        for (User user: users) {
            userDtos.add(UserMapper.toUserDto(user));
        }
        return userDtos;
    }

    @Override
    public UserDto getUserById(int id) {
        for(User user: users ){
            if(user.getId() == id){
                return UserMapper.toUserDto(user);
            }
        }
        throw new NotFoundException("User khong ton tai trong he thong");
    }

    @Override
    public List<UserDto> searchUser(String keyword) {
        List<UserDto> result =  new ArrayList<>();
        for(User user: users){
            if(user.getName().contains(keyword)){
                result.add(UserMapper.toUserDto(user));
            }
        }
        return result;
    }
}
