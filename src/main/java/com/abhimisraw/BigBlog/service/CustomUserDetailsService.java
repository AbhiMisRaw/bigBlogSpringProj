package com.abhimisraw.BigBlog.service;

import com.abhimisraw.BigBlog.domain.User;
import com.abhimisraw.BigBlog.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username)
                .orElseThrow(()-> new UsernameNotFoundException("Email "+username+" not found."));

        System.out.println("we got the user : " + user.getEmail() +" password "+ user.getPassword() +" auth "+ user.getAuthorities());



        return new org.springframework.security.core.userdetails.User(user.getEmail() , user.getPassword() , user.getAuthorities());

//        @Override
//        public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//            UserInfo activeUserInfo = userInfoDAO.getActiveUser(userName);
//            String dBuserName = activeUserInfo.getUserName();
//            if(dBuserName == null){
//                throw new UsernameNotFoundException("User not authorized.");
//            }
//            GrantedAuthority authority = new SimpleGrantedAuthority(activeUserInfo.getRole());
//            UserDetails userDetails = (UserDetails)new User(dBuserName,
//                    activeUserInfo.getPassword(), Arrays.asList(authority));
//            return userDetails;
//        }
    }





}
