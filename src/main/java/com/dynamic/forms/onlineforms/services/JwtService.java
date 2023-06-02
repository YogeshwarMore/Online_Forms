package com.dynamic.forms.onlineforms.services;

import com.dynamic.forms.onlineforms.dao.UserDao;
import com.dynamic.forms.onlineforms.entities.JwtRequest;
import com.dynamic.forms.onlineforms.entities.JwtResponse;
import com.dynamic.forms.onlineforms.entities.User;
import com.dynamic.forms.onlineforms.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDao userDao;

    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String useremailid = jwtRequest.getUseremailid();

        UserDetails userDetails = loadUserByUsername(useremailid);
        String newGeneratedToken = jwtUtil.generateToken(userDetails);

        User user = userDao.findByUseremailid(useremailid);

        StringBuilder roleNamesBuilder = new StringBuilder();
        user.getRole().forEach(re -> {
            roleNamesBuilder.append(re.getRolename()).append(", ");
        });
        String roleNames = roleNamesBuilder.toString().trim();
        if (roleNames.endsWith(",")) {
            roleNames = roleNames.substring(0, roleNames.length() - 1);
        }

        return new JwtResponse(roleNames, newGeneratedToken,user.getUserid());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUseremailid(username);
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getUseremailid(),"",
                    getAuthority(user)
            );
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    private Set getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRole().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("Role_"+role.getRolename()));
        });
        return authorities;
    }



}