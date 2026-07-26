import React from 'react';
import './App.css';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';
import {books, blogs, courses} from './data';

function App() {
  const bookdet = <BookDetails books={books} />;
  const content = <BlogDetails blogs={blogs} />;
  const coursedet = <CourseDetails courses={courses} />;

  return (
    <div>
      <div className="App">
        <div className="mystyle1">
          <h1>Course Details</h1>
          {coursedet}
        </div>
        <div className="st2">
          <h1>Book Details</h1>
          {bookdet}
        </div>
        <div className="v1">
          <h1>Blog Details</h1>
          {content}
        </div>
      </div>
    </div>
  );
}

export default App;
