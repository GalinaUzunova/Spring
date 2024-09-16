package org.pathfinder2.servises;

import org.modelmapper.ModelMapper;
import org.pathfinder2.model.LoginDto;
import org.pathfinder2.model.User;
import org.pathfinder2.model.UserProfileDto;
import org.pathfinder2.repository.UserRepository;
import org.pathfinder2.web.UserRegisterDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private ModelMapper mapper;

    private UserRepository userRepository;
    private PasswordEncoder encoder;
    private CurrentUserSession currentuser;

    public UserServiceImpl(ModelMapper mapper, UserRepository userRepository, PasswordEncoder encoder, CurrentUserSession currentuser) {
        this.mapper = mapper;
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.currentuser = currentuser;
    }


    public void registerUser(UserRegisterDto userRegisterDto) {
        User user = mapper.map(userRegisterDto, User.class);

        user.setPassword(encoder.encode(userRegisterDto.getPassword()));


        this.userRepository.save(user);


    }

    public boolean userLogin(LoginDto loginDto) {

        User user = this.userRepository.findByUserName(loginDto.getUsername());

        if (user == null || loginDto.getPassword() == null) {
            return false;
        }
      //  boolean sucsses = encoder.matches(loginDto.getPassword(), user.getPassword());

     //    if (sucsses) {



       currentuser.setFullName(user.getFullName());
       currentuser.isLoggIn();
       boolean sucsses=true;


      //   } else {
    //          currentuser.clean();
    //    }
        return true;
    }


        public void logout () {
            currentuser.clean();
        }

        public UserProfileDto getProfile () {

        User loggedUser=this.userRepository.findByUserName(currentuser.getFullName());
        if(loggedUser==null){
            throw  new RuntimeException("no usre");
        }


            return this.mapper.map(loggedUser, UserProfileDto.class);
        }
    }


