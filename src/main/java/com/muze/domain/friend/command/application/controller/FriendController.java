package com.muze.domain.friend.command.application.controller;

import com.muze.domain.friend.command.application.dto.FriendDTO;
import com.muze.domain.friend.command.application.service.AddFriendService;
import com.muze.domain.friend.command.application.service.DeleteFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/friend")
public class FriendController {

    private final AddFriendService addFriendService;
    private final DeleteFriendService deleteFriendService;

    @Autowired
    public FriendController(AddFriendService addFriendService, DeleteFriendService deleteFriendService) {
        this.addFriendService = addFriendService;
        this.deleteFriendService = deleteFriendService;
    }

    @PostMapping
    public ResponseEntity<?> addFriend(
            @RequestBody @Valid FriendDTO friendDTO, BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            List<FieldError> list = bindingResult.getFieldErrors();
            for (FieldError error : list) {
                return new ResponseEntity<>(error.getDefaultMessage(), HttpStatus.BAD_REQUEST);
            }
        }
        if (addFriendService.checkFriend(friendDTO)) {
            return ResponseEntity.ok("이미 친구로 등록된 유저입니다.");

        } else {
            addFriendService.addFriend(friendDTO);
            return ResponseEntity.ok("정상적으로 등록되었습니다.");
        }

    }

    @DeleteMapping
    public ResponseEntity<?> deleteFriend(
            @RequestBody @Valid FriendDTO friendDTO, BindingResult bindingResult

    ) {
        if (bindingResult.hasErrors()) {
            List<FieldError> list = bindingResult.getFieldErrors();
            for (FieldError error : list) {
                return new ResponseEntity<>(error.getDefaultMessage(), HttpStatus.BAD_REQUEST);
            }
        }
        deleteFriendService.deleteFriend(friendDTO);
        return ResponseEntity.ok("정상적으로 삭제되었습니다.");
    }
}
