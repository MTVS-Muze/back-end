package com.muze.domain.playlist.command.application.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@NoArgsConstructor
@ToString
public class CreatePlaylistDTO {
    @NotNull
    @Positive
    private Long memberId;

    @NotBlank
    private String title;

    public CreatePlaylistDTO(Long memberId, String title) {
        this.memberId = memberId;
        this.title = title;
    }
}
