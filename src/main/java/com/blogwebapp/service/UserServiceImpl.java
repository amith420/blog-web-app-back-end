package com.blogwebapp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogwebapp.model.PreviousId;
import com.blogwebapp.model.UserModel;
import com.blogwebapp.repository.PreviousIdRepository;
import com.blogwebapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PreviousIdRepository previousIdRepository;

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserModel create(UserModel user) {
        if (userRepo.existsByEmail(user.getEmail())) {
            return null;
        }

        PreviousId previousIdModel = previousIdRepository.findByType("user");
        Integer previousUserId = previousIdModel.getPreviousId();

        if (previousUserId < 9) {
            user.setId("UN00" + ++previousUserId);
        } else {
            user.setId("UN0" + ++previousUserId);
        }

        previousIdModel.setPreviousId(previousUserId);
        previousIdRepository.save(previousIdModel);
        user.setCreatedAt(new Date());
        user.setRole("user");
        return userRepo.save(user);
    }

    @Override
    public List<UserModel> findAll() {
        return userRepo.findAll();
    }

    @Override
    public UserModel findById(String id) {
        return userRepo.findById(id).get();
    }

    @Override
    public void delete(String id) {
        userRepo.deleteById(id);
    }

    @Override
    public UserModel update(UserModel user) {
        return userRepo.save(user);
    }

    @Override
    public UserModel checkEmailAndPassword(String email, String password) {
        return userRepo.findByEmailAndPassword(email, password);
    }

}
