package kr.ac.mjc.movie.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kr.ac.mjc.movie.domain.User;
import kr.ac.mjc.movie.dto.UpdateUserRequest;
import kr.ac.mjc.movie.dto.UserRequest;
import kr.ac.mjc.movie.dto.UserResponse;
import kr.ac.mjc.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    // 회원가입
    @PostMapping("/api/join")
    public ResponseEntity<UserResponse> join(@RequestBody UserRequest request) {
        UserResponse response = userService.join(request);
        return ResponseEntity.ok().body(response);
    }

    // 로그인, 세션 적용(로그인 상태 유지)
    @PostMapping("/api/login")
    public ResponseEntity<UserResponse> login(@RequestBody UserRequest request, HttpServletRequest httpServletRequest) {
        UserResponse response = userService.login(request);
        HttpSession session = httpServletRequest.getSession(true);

        // 로그인 실패한 경우
        if(!response.isSuccess()) {
            return ResponseEntity.ok().body(response);
        }

        // 로그인 성공한 경우
        session.setAttribute("userId",response.getUser().getEmail());
        session.setAttribute("userNum",response.getUser().getId());
        return ResponseEntity.ok().body(response);
    }

    // 로그아웃
    @PostMapping("/api/logout")
    public ResponseEntity<String> logout(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession(false);

        if(session != null) {
            session.invalidate();
        }

        return ResponseEntity.ok().body("Logged out successfully");
    }

    // 내 정보 수정
    @PutMapping("/api/userInfo/{id}")
    public ResponseEntity<User> updateUser(@RequestBody UpdateUserRequest request, HttpServletRequest httpServletRequest) {
        User user = userService.update(httpServletRequest, request);
        if(user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}