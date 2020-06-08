package controller;

import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.CommentService;

import java.util.Map;

/**
 * Created by zwl on 2017/9/11.
 * May god bless me
 */
@Controller
public class CommentController extends  BaseController<Comment> {
    @Autowired
    private CommentService commentService;

    @Override
    public void afterPropertiesSet() throws Exception {
        setBaseService( commentService);
    }

    /**
     * 添加 t
     *
     * @param comment
     * @return
     */
    @Override
    @RequestMapping(value = "/POST/comment2",method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> addT2(Comment comment) {
        return super.addT2(comment);
    }

    /**
     * 分页查询
     *
     * @param pageNum
     * @param pageSize
     * @param where
     * @return
     */
    @Override
    @RequestMapping(value = "/GET/comments",method = {RequestMethod.GET,RequestMethod.POST})
    public  @ResponseBody  Map<String, Object> getAllT(@RequestParam(value = "page",required = false) int pageNum,
                                       @RequestParam(value = "rows",required = false) int pageSize,
                                       @RequestParam(value = "where",required = false) String where) {
        return super.getAllT(pageNum, pageSize, where);
    }

    /**
     * url 删除
     *
     * @param ids
     * @return
     */
    @Override
    @RequestMapping(value = "/DELETE/comment/{ids}")
    public @ResponseBody  Map<String, Object> removeT1(@PathVariable("ids") String ids) {
        return super.removeT1(ids);
    }

    /**
     * ajax删除
     *
     * @param ids
     * @return
     */
    @Override
    @RequestMapping(value = "/DELETE/comments")
    public @ResponseBody  Map<String, Object> removeT2(@RequestParam("ids") String ids) {
        return super.removeT2(ids);
    }

    @Override
    @RequestMapping(value = "/PUT/comment")
    public @ResponseBody  Map<String, Object> updateT(Comment comment) {
        return super.updateT(comment);
    }
}
