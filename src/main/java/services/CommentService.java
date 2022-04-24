package services;

import model.Comment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import proxies.CommentNotificationProxy;
import repositories.CommentRepository;

import java.util.logging.Logger;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;
    private Logger logger = Logger.getLogger(CommentService.class.getName());

    public CommentService(CommentRepository commentRepository,
                          CommentNotificationProxy commentNotificationProxy) {

        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    @ToLog
    public String publishComment(Comment comment) {

        logger.info("Publishing comment:" + comment.getText());

        // Omitted code:

        return "SUCCESS";
    }

    public void deleteComment(Comment comment) {
        logger.info("Deleting comment:" + comment.getText());
    }

    public void editComment(Comment comment) {
        logger.info("Editing comment:" + comment.getText());
    }
}
