import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import Dashboard from "./components/Dashboard";
import LocalUserList from "./components/LocalUserList";
import UserList from "./components/UserList";
import FakePostList from "./components/FakePostList";
import "./App.css";

function App() {
  return (
    <Router>
      <div className="app-wrapper">
        <nav className="navbar">
          <Link to="/" className="nav-brand">📰 NewsPortal</Link>
          <div className="nav-links">
            <Link to="/">Home</Link>
            <Link to="/local-users">Local Users</Link>
            <Link to="/users-api">Users API</Link>
            <Link to="/fake-posts">Fake Posts</Link>
          </div>
        </nav>

        <main className="main-content">
          <Routes>
            <Route path="/" element={<Dashboard />} />
            <Route path="/local-users" element={<LocalUserList />} />
            <Route path="/users-api" element={<UserList />} />
            <Route path="/fake-posts" element={<FakePostList />} />
          </Routes>
        </main>

        <footer className="app-footer">
          <p>Skill 11 — React API Integration | FSAD Practical</p>
        </footer>
      </div>
    </Router>
  );
}

export default App;
