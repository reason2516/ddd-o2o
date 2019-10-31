package com.wmx.o2o.provider.user.service.domain.user;

import com.wmx.o2o.provider.user.client.dto.command.UserRegisterCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterDomainService {

    @Autowired
    private UserRepository userRepository;

    public User doRegister(UserRegisterCommand command) {
        if (userRepository.existsByPhoneNumber(command.getPhoneNumber())) {
            throw new RuntimeException("用户已存在");
        }

        // TODO 密码加密
        User user = new User();
        user.setId(userRepository.nextId());
        user.registerByPhoneNumber(command.getPhoneNumber(), command.getPassword());
        return userRepository.save(user);
    }
}
