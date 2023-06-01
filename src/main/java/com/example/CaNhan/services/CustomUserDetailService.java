package com.example.CaNhan.services;

import com.example.CaNhan.entity.CustomUserDetail;
import com.example.CaNhan.entity.User;
import com.example.CaNhan.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByUsername(username);
        if(user==null)
            throw new UsernameNotFoundException("User not found");
        return (UserDetails) new CustomUserDetail(user,userRepository);
    }
}
