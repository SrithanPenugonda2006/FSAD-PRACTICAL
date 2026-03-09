import { useState, useEffect } from "react";
import axios from "axios";
import "./FakePostList.css";

const USER_IDS = ["All", 1, 2, 3, 4, 5];

function FakePostList() {
    const [posts, setPosts] = useState([]);
    const [filteredPosts, setFilteredPosts] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const [selectedUserId, setSelectedUserId] = useState("All");

    const fetchPosts = () => {
        setLoading(true);
        setError(null);
        axios
            .get("https://dummyjson.com/posts?limit=30")
            .then((res) => {
                setPosts(res.data.posts);
                setFilteredPosts(res.data.posts);
                setLoading(false);
            })
            .catch((err) => {
                setError(err.message);
                setLoading(false);
            });
    };

    useEffect(() => {
        fetchPosts();
    }, []);

    useEffect(() => {
        if (selectedUserId === "All") {
            setFilteredPosts(posts);
        } else {
            setFilteredPosts(posts.filter((p) => p.userId === Number(selectedUserId)));
        }
    }, [selectedUserId, posts]);

    return (
        <div className="list-container">
            <div className="fakelist-header">
                <h2 className="list-title">🗞️ Fake API Posts (DummyJSON)</h2>
                <div className="controls">
                    <label htmlFor="userFilter">Filter by User ID:</label>
                    <select
                        id="userFilter"
                        value={selectedUserId}
                        onChange={(e) => setSelectedUserId(e.target.value)}
                        className="filter-select"
                    >
                        {USER_IDS.map((uid) => (
                            <option key={uid} value={uid}>
                                {uid === "All" ? "All Users" : `User ${uid}`}
                            </option>
                        ))}
                    </select>
                    <button className="refresh-btn" onClick={fetchPosts}>
                        🔄 Refresh
                    </button>
                </div>
            </div>

            {loading && <div className="status-msg loading">⏳ Loading posts...</div>}
            {error && <div className="status-msg error">❌ Error: {error}</div>}

            {!loading && !error && (
                <div className="posts-grid">
                    {filteredPosts.length === 0 ? (
                        <p className="no-results">No posts found for this filter.</p>
                    ) : (
                        filteredPosts.map((post) => (
                            <div key={post.id} className="post-card">
                                <div className="post-meta">
                                    <span className="post-user">User {post.userId}</span>
                                    <span className="post-id">#{post.id}</span>
                                </div>
                                <h3 className="post-title">{post.title}</h3>
                                <p className="post-body">{post.body}</p>
                                <div className="post-tags">
                                    {post.tags?.map((tag) => (
                                        <span key={tag} className="tag">
                                            #{tag}
                                        </span>
                                    ))}
                                </div>
                            </div>
                        ))
                    )}
                </div>
            )}
        </div>
    );
}

export default FakePostList;
