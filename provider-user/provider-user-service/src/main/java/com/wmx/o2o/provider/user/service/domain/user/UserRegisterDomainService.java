package com.wmx.o2o.provider.user.service.domain.user;

import com.wmx.o2o.provider.user.client.beans.command.UserRegisterCommand;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterDomainService {

    private final UserRepository userRepository;

    public UserRegisterDomainService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User doRegister(UserRegisterCommand command) {
        if (userRepository.existsByPhoneNumber(command.getPhoneNumber())) {
            throw new RuntimeException("用户已存在");
        }

        // TODO 密码加密
        User user = new User();
        user.registerByPhoneNumber(userRepository.nextId(), command.getPhoneNumber(), command.getPassword());

        return userRepository.save(user);
    }
}
