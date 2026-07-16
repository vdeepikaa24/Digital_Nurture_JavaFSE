import React, { Component } from 'react';

class Posts extends Component {
    constructor(props) {
        super(props);
        this.state = { posts: [] }; // Initialize state
    }

    loadPosts() {
        // Fetch API call
        fetch('https://jsonplaceholder.typicode.com/posts')
            .then(response => response.json())
            .then(data => this.setState({ posts: data })) // Assign to state
            .catch(error => console.error('Error fetching data:', error));
    }

    componentDidMount() {
        this.loadPosts(); // Call loadPosts when component mounts
    }

    componentDidCatch(error, info) {
        // Display error as alert message
        alert("An error occurred: " + error.toString());
    }

    render() {
        return (
            <div>
                <h1>Blog Posts</h1>
                {/* Map through posts to display title and body */}
                {this.state.posts.map(post => (
                    <div key={post.id}>
                        <h3>{post.title}</h3> {/* Heading for title */}
                        <p>{post.body}</p>   {/* Paragraph for post body */}
                    </div>
                ))}
            </div>
        );
    }
}
export default Posts;