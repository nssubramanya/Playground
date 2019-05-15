import React, { Component } from 'react';
import axios from 'axios';

import Post from '../../components/Post/Post';
import FullPost from '../../components/FullPost/FullPost';
import NewPost from '../../components/NewPost/NewPost';
import classes from "./Blog.module.css";

class Blog extends Component {
  state = {
    posts: [],
    selectedPostId: null
  }

  componentDidMount() {
    axios.get('https://jsonplaceholder.typicode.com/posts')
      .then(response => {
        const posts = response.data.slice(0, 4);
        const updatedPosts = posts.map(post => {
          return {
            ...post,
            author: 'Max'
          }
        });

        this.setState({ posts: updatedPosts });
      })
      .catch(error => {
        console.log(error);
        alert('Unable to get posts!');
      });


  }

  postSelectHandler = (id) => {
    console.log("Post clicked: " + id);
    this.setState({ selectedPostId: id });
  }

  render() {
    const posts = this.state.posts.map(post => {
      return <Post
        key={post.id}
        title={post.title}
        author={post.author}
        clicked={() => this.postSelectHandler(post.id)} />
    });


    return (
      <div>
        <section className={classes.Posts}>
          {posts}
        </section>
        <section>
          <FullPost id={this.state.selectedPostId} />
        </section>
        <section>
          <NewPost />
        </section>
      </div>
    );
  }
}

export default Blog;