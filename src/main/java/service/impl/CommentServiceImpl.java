package service.impl;

import dao.CommentMapper;
import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CommentService;

import java.util.List;

/**
 * Created by zwl on 2017/9/10.
 * May god bless me
 */
@Service
public class CommentServiceImpl extends BaseServiceImpl<Comment> implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public void afterPropertiesSet() throws Exception {
        setBaseMapper(commentMapper);
    }
}
