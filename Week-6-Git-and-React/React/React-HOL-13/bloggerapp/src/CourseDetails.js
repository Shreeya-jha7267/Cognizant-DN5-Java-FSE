import React from 'react';

function CourseDetails(props) {
  const coursedet = (
    <ul>
      {props.courses.map((course) =>
        <div key={course.id}>
          <h3>{course.cname}</h3>
          <h4>{course.date}</h4>
        </div>
      )}
    </ul>
  );
  return coursedet;
}

export default CourseDetails;
