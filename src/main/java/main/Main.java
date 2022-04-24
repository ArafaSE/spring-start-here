package main;

import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import proxies.EmailCommentNotificationProxy;
import repositories.DBCommentRepository;
import services.CommentService;

import java.util.logging.Logger;

public class Main {

    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var comment = new Comment();
        comment.setAuthor("Mohamed");
        comment.setText("Demo Comment");

        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
        commentService.deleteComment(comment); // the only annotated method by Aspect
        commentService.editComment(comment);

/**
   Old way without using Spring context
 */
        /*
        var commentRepository = new DBCommentRepository();
        var commentNotificationProxy = new EmailCommentNotificationProxy();

        // Using dependency injection with abstraction
        var commentService = new CommentService(commentRepository, commentNotificationProxy);
        var comment = new Comment();
        comment.setAuthor("Mohamed");
        comment.setText("Demo Comment");

        commentService.publishComment(comment);

         */
    }
}
