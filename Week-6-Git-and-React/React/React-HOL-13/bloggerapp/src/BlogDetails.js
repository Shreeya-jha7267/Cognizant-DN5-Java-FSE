import React from 'react';

function BlogDetails(props) {
  const content = (
    <ul>
      {props.blogs.map((blog) =>
        <div key={blog.id}>
          <h3>{blog.title}</h3>
          <h4>Author: {blog.author}</h4>
          <p>{blog.description}</p>
        </div>
      )}
    </ul>
  );
  return content;
}

export default BlogDetails;
