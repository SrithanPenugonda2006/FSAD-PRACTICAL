import { useState, useEffect } from "react";
import "./LocalUserList.css";

function LocalUserList() {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetch("/users.json")
      .then((res) => {
        if (!res.ok) throw new Error("Failed to fetch local users");
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

  if (loading) return <div className="status-msg loading">⏳ Loading local users...</div>;
  if (error) return <div className="status-msg error">❌ Error: {error}</div>;

  return (
    <div className="list-container">
      <h2 className="list-title">📂 Local Users (users.json)</h2>
      <div className="cards-grid">
        {users.map((user) => (
          <div key={user.id} className="user-card">
            <div className="user-avatar">{user.name.charAt(0)}</div>
            <div className="user-info">
              <h3>{user.name}</h3>
              <p>📧 {user.email}</p>
              <p>📞 {user.phone}</p>
              <p>🏙️ {user.city}</p>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default LocalUserList;
