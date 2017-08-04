package hello;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@MapperScan("com.neo.mapper")
public class Application {
   // private static  UserMapper UserMapper  ;
    public static void mains(String[] args) {
//        testInsert();
//        testQuery();
//        testUpdate();

        SpringApplication.run(Application.class, args);
    }

//
//    private static void testInsert()  {
//        UserMapper.insert(new UserEntity("aa", "a123456", UserSexEnum.MAN));
//        UserMapper.insert(new UserEntity("bb", "b123456", UserSexEnum.WOMAN));
//        UserMapper.insert(new UserEntity("cc", "b123456", UserSexEnum.WOMAN));
//
//
//    }
//
//
//    public static void testQuery()
//    {
//        List<UserEntity> users = UserMapper.getAll();
//        if(users==null || users.size()==0){
//            System.out.println("is null");
//        }else{
//            System.out.println(users.toString());
//        }
//    }
//
//
//
//    public static void testUpdate()
//    {
//        UserEntity user = UserMapper.getOne(6l);
//        System.out.println(user.toString());
//        user.setNickName("neo");
//        UserMapper.update(user);
//
//    }
}

