package com.project.board.board.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDto {
    private Long replyId;
    private String content;
    private Long memberSeq;
    private CommentDto parentComment;
}
