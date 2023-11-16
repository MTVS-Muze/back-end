package com.muze.domain.friend.command.application.controller;

import com.muze.domain.friend.command.application.dto.FriendDTO;
import com.muze.domain.friend.command.application.service.AddFriendService;
import com.muze.domain.friend.command.application.service.DeleteFriendService;
import com.muze.domain.map.command.application.dto.ResponseMapDTO;
import com.muze.global.common.annotation.CurrentMember;
import com.muze.global.security.principal.UserPrincipal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "친구 등록", description = "다른 사용자를 친구로 등록")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "친구 저장 성공",
                    content = @Content(
                            schema = @Schema())),
            @ApiResponse(
                    responseCode = "400",
                    description = "필요한 값을 보내주지 않음",
                    content = @Content(
                            schema = @Schema())),
    })

    @PostMapping
    public ResponseEntity<?> addFriend(
            @RequestBody @Valid FriendDTO friendDTO, BindingResult bindingResult,
            @Parameter(hidden = true) @CurrentMember UserPrincipal userPrincipal
            ) {
        if (bindingResult.hasErrors()) {
            List<FieldError> list = bindingResult.getFieldErrors();
            for (FieldError error : list) {
                return new ResponseEntity<>(error.getDefaultMessage(), HttpStatus.BAD_REQUEST);
            }
        }

        friendDTO.setMemberId(userPrincipal.getId());
        if (addFriendService.checkFriend(friendDTO)) {
            return ResponseEntity.ok("이미 친구로 등록된 유저입니다.");

        } else {
            addFriendService.addFriend(friendDTO);
            return ResponseEntity.ok("정상적으로 등록되었습니다.");
        }

    }


    @Operation(summary = "친구 삭제", description = "등록된 친구를 삭제")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "친구 삭제 성공",
                    content = @Content(
                            schema = @Schema()))
    })
    @DeleteMapping
    public ResponseEntity<?> deleteFriend(
            @RequestBody @Valid FriendDTO friendDTO, BindingResult bindingResult,
            @Parameter(hidden = true) @CurrentMember UserPrincipal userPrincipal
    ) {
        if (bindingResult.hasErrors()) {
            List<FieldError> list = bindingResult.getFieldErrors();
            for (FieldError error : list) {
                return new ResponseEntity<>(error.getDefaultMessage(), HttpStatus.BAD_REQUEST);
            }
        }
        friendDTO.setMemberId(friendDTO.getMemberId());
        deleteFriendService.deleteFriend(friendDTO);
        return ResponseEntity.ok("정상적으로 삭제되었습니다.");
    }
}
