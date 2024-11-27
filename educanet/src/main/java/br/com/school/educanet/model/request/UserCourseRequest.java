package br.com.school.educanet.model.request;

import org.springframework.stereotype.Component;

@Component
public class UserCourseRequest {

    private Long userId ;
    private Long  courseId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
