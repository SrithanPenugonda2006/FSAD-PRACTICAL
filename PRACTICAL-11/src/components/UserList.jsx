import { useState, useEffect } from "react";
import "./UserList.css";

function UserList() {
    const [users, setUsers] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        fetch("https://jsonplaceholder.typicode.com/users")
            .then((res) => {
                if (!res.ok) throw new Error("Failed to fetch from JSONPlaceholder");
                return res.json();
            })
            .then((data) => {
                setUsers(data);
                setLoading(false);
            })
            .catch((err) => {
                setError(err.message);
                setLoading(false);
            });
    }, []);

    if (loading) return <div className="status-msg loading">⏳ Loading users from API...</div>;
    if (error) return <div className="status-msg error">❌ Error: {error}</div>;

    return (
        <div className="list-container">
            <h2 className="list-title">🌐 Users API (JSONPlaceholder)</h2>
            <div className="cards-grid">
                {users.map((user) => (
                    <div key={user.id} className="user-card">
                        <div className="user-avatar">{user.name.charAt(0)}</div>
                        <div className="user-info">
                            <h3>{user.name}</h3>
                            <p>📧 {user.email}</p>
                            <p>📞 {user.phone}</p>
                            <p>🌍 {user.address?.city}</p>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
}

export default UserList;
