package com.acapawnshop.api.service;

import com.acapawnshop.api.dto.CredentialsCreateDTO;
import com.acapawnshop.api.dto.UserCreateDTO;
import com.acapawnshop.api.entity.Address;
import com.acapawnshop.api.entity.Bank;
import com.acapawnshop.api.entity.Credentials;
import com.acapawnshop.api.entity.User;
import com.acapawnshop.api.repository.AddressRepository;
import com.acapawnshop.api.repository.BankRepository;
import com.acapawnshop.api.repository.CredentialsRepository;
import com.acapawnshop.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private CredentialsRepository credentialsRepository;

    public void registerUser(UserCreateDTO request) {
        User user = new User(request.getUserDTO());
        userRepository.save(user);

        Address address = new Address(request.getAddressDTO());
        user.addAddress(address);
        addressRepository.save(address);

        Bank bank = new Bank(request.getBankDTO());
        user.addFinance(bank);
        bankRepository.save(bank);

    }

    public void signInUser(CredentialsCreateDTO request, Long userId) {
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException("User not found"));

        Credentials credentials = new Credentials();
        credentials.setUserName(request.getUserName());
        //String encodedPassword = passwordEncoder.encode(request.getPsswd());
        credentials.setPsswd(request.getPsswd());
        credentials.setUser(user);

        user.addCredentials(credentials);
        credentialsRepository.save(credentials);
    }
}
