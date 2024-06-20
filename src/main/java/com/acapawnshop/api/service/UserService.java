package com.acapawnshop.api.service;

import com.acapawnshop.api.dto.UserCreateDTO;
import com.acapawnshop.api.entity.Address;
import com.acapawnshop.api.entity.Bank;
import com.acapawnshop.api.entity.User;
import com.acapawnshop.api.repository.AddressRepository;
import com.acapawnshop.api.repository.BankRepository;
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
}
