package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminService {
    private final UserRepository userRepository;

    public AdminService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // TODO: 4. find or save 예제 개선
    @Transactional
    public void reportUsers(List<Long> userIds) {

        // 리스트로 유저 조회
        List<User> userIdList = userRepository.findByIdIn(userIds);

        // 조회한 유저 상태 변경
        for (User user : userIdList) {

            user.updateStatusToBlocked();
        }

        //변경한 유저들을 리스트로 한 번에 저장
        userRepository.saveAll(userIdList);
    }
}
