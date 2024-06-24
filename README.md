# SpringBootRestAPIs

## getCourses GET Api
Uses CourseService Interface to call method present in the CourseServiceImpl Class. \
When we Call the method .getCourse(), this will call the getCourse() of the Interface (ie (CourseService) here Runtime polymorphism will happen and it will call the body method present in CourseServiceImpl Class

## getCourse GET Api
Gets Info about a particular course using courseId passed from params

## addCourse POST Api
adds a new course with the data passed in the body

## updateCourse PUT Api
Update Info about a particular course using courseId passed from params and newinfo from Body

## deleteCourse DELETE Api
deletes the course according to courseId passed iin Path Variable
