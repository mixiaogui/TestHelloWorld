package com.neo.web;

import java.util.List;

import com.neo.enums.UserSexEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neo.entity.UserEntity;
import com.neo.mapper.UserMapper;
import com.neo.mapper.test1.User1Mapper;
import com.neo.mapper.test2.User2Mapper;

@RestController
public class UserController {
	
	@Autowired
	private UserMapper userMapper;

    @Autowired
    private User1Mapper user1Mapper;

    @Autowired
    private User2Mapper user2Mapper;

	@RequestMapping("/getUsers")
	public List<UserEntity> getUsers() {
		List<UserEntity> users=userMapper.getAll();
		return users;
	}
	
    @RequestMapping("/getUser")
    public UserEntity getUser(Long id) {
    	UserEntity user=userMapper.getOne(id);
        return user;
    }
    
    @RequestMapping("/add")
    public void save(UserEntity user) {
    	userMapper.insert(user);
    }
    
    @RequestMapping(value="update")
    public void update(UserEntity user) {
    	userMapper.update(user);
    }
    
    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
    	userMapper.delete(id);
    }

    @RequestMapping("/test")
    public void test(@RequestParam(value="name", defaultValue="World") String name ) {
        System.out.println("###test 被调用 ！！！"+name);
	    UserEntity userEntity = new UserEntity();
		userEntity.setUserName(name);
		userEntity.setUserSex(UserSexEnum.MAN);
		userEntity.setPassWord("123");
		userMapper.insert(userEntity);

    }

    @RequestMapping("/test1")
    public void test1(@RequestParam(value="name", defaultValue="World") String name ) {
        System.out.println("###test1 b被调用 ！！！"+name );
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(name);
        userEntity.setUserSex(UserSexEnum.MAN);
        userEntity.setPassWord("123");
        user1Mapper.insert(userEntity);

    }
    @RequestMapping("/test2")
    public void test2(@RequestParam(value="name", defaultValue="World") String name ) {
	    System.out.println("###test2 b被调用 ！！！");
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(name);
        userEntity.setUserSex(UserSexEnum.MAN);
        userEntity.setPassWord("123");
        user2Mapper.insert(userEntity);

    }


}