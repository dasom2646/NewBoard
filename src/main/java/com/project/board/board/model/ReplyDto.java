package com.project.board.board.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDto {
    private Long replySeq;
    private String content;
    private String createdDate;

    private Long memberSeq;
    private CommentDto parentComment;
}
