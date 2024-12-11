package kr.ac.mjc.movie.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import kr.ac.mjc.movie.domain.MovieList;
import kr.ac.mjc.movie.domain.Review;
import kr.ac.mjc.movie.domain.User;
import kr.ac.mjc.movie.dto.UpdateUserRequest;
import kr.ac.mjc.movie.dto.UserRequest;
import kr.ac.mjc.movie.dto.UserResponse;
import kr.ac.mjc.movie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 회원가입
    public UserResponse join(UserRequest request) {

        User checkUser = userRepository.findByEmail(request.getEmail());

        UserResponse response = new UserResponse();

        // 이미 가입된 이메일인 경우
        if(checkUser != null) {
            response.setSuccess(false);
            response.setMessage("이미 가입된 이메일입니다.");
            return response;
        }

        // 가입된 이메일이 없는 경우
        userRepository.save(request.toEntity());
        response.setSuccess(true);
        response.setMessage("회원가입이 완료되었습니다.");
        response.setUser(checkUser);
        return response;
    }

    // 로그인
    public UserResponse login(UserRequest request) {
        UserResponse response = new UserResponse();
        User checkUser = userRepository.findByEmailAndPassword(request.getEmail(), request.getPassword());

        // 아이디 또는 패스워드가 틀린 경우
        if(checkUser == null) {
            response.setSuccess(false);
            response.setMessage("아이디 또는 패스워드가 틀렸습니다.");
            return response;
        }

        // 아이디와 패스워드가 맞을 경우
        response.setSuccess(true);
        response.setMessage("로그인 성공");
        response.setUser(checkUser);
        return response;
    }

    public User findOne(long id) {
        User user = userRepository.findById((int) id).orElseThrow(); // 찾아내지 못할 경우 에러가 발생하게 처리 -> orElseThrow
        return user;
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Transactional // 어노테이션을 사용해야 업데이트가 진행된 후 데이터베이스에 적용, import 할 때 spring에 있는 것을 사용해야 함
    public User update(HttpServletRequest httpServletRequest, UpdateUserRequest request) {
        HttpSession session = httpServletRequest.getSession(true);
        String userEmail = (String) session.getAttribute("userId");
        User user = userRepository.findByEmail(userEmail);

        if (user != null) {
            user.setName(request.getName());
            user.setPassword(request.getPassword());
            user.setPhoneNumber(request.getPhoneNumber());
            return userRepository.save(user);
        } else {
            return null;
        }
    }
}
