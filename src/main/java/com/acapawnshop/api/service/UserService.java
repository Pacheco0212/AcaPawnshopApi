package com.acapawnshop.api.service;
import com.acapawnshop.api.dto.user.UserCredentialsCreateDTO;
import com.acapawnshop.api.dto.user.UserCreateDTO;
import com.acapawnshop.api.entity.Address;
import com.acapawnshop.api.entity.Bank;
import com.acapawnshop.api.entity.Credentials;
import com.acapawnshop.api.entity.User;
import com.acapawnshop.api.jwt.TokenGenerator;
import com.acapawnshop.api.repository.AddressRepository;
import com.acapawnshop.api.repository.BankRepository;
import com.acapawnshop.api.repository.CredentialsRepository;
import com.acapawnshop.api.repository.UserRepository;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.security.Key;

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
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private TokenGenerator tokenGenerator;

    private final String secretKey = "2bd3c48b-eed0-4c14-84d0-3dc5c9d902c5";
    private final Key key = Keys.hmacShaKeyFor(secretKey.getBytes());

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

    public String signInUser(UserCredentialsCreateDTO request, Long userId) {
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException("User not found"));

        Credentials credentials = new Credentials();
        credentials.setUserName(request.getUserName());
        String encodedPassword = passwordEncoder.encode(request.getPsswd());
        credentials.setPsswd(encodedPassword);
        credentials.setUser(user);

        user.addCredentials(credentials);
        credentialsRepository.save(credentials);

        //User Authentication
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPsswd()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //Load user details
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUserName());

        //Create and return token jwt
        return tokenGenerator.generateToken(userDetails);
    }

    public String logInUser(UserCredentialsCreateDTO request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPsswd()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final  UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUserName());

        return tokenGenerator.generateToken(userDetails);
    }

}
