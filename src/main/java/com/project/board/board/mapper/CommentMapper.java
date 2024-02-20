package com.project.board.board.mapper;

import com.project.board.board.model.CommentDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    // 댓글 저장
    void insertComment(CommentDto commentDto);


    // 해당 게시글에 대한 댓글 목록 가져오기
    List<CommentDto> getCommentsForBoard(@Param("boardSeq") Long boardSeq);

/*    // 작성자로 조회
    List<CommentDto> getAllCommentsByMemberSeq(Long memberSeq);*/

    List<CommentDto> getRepliesForComment(Long commentSeq);
}
