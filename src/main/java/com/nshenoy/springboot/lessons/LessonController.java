package com.nshenoy.springboot.lessons;

import java.util.List;

import com.nshenoy.springboot.courses.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LessonController {

    @Autowired
    private LessonService lessonService;

    // Get All Lessons
    @RequestMapping("/topics/{topicId}/courses/{courseId}/lessons")
    public List<Lesson> getAllCourses(@PathVariable String courseId) {
        return lessonService.getAllLessons(courseId);
    }

    // Get Lesson by Id
    @RequestMapping("/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
    public Lesson getTopic(@PathVariable String lessonId) {
        return lessonService.getLesson(lessonId);
    }

    // Add Lesson
    @RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses/{courseId}/lessons")
    public void addTopic(@RequestBody Lesson lesson, @PathVariable String topicId, @PathVariable String courseId) {
        lesson.setCourse(new Course(courseId, "", "", topicId));
        lessonService.addLesson(lesson);
    }

    // Update Lesson By Id
    @RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
    public void updateTopic(@RequestBody Lesson lesson, @PathVariable String lessonId) {
        lessonService.updateLesson(lessonId, lesson);
    }

    // Delete Lesson by Id
    @RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
    public void deleteTopic(@PathVariable String lessonId) {
        lessonService.deleteLesson(lessonId);
    }
}