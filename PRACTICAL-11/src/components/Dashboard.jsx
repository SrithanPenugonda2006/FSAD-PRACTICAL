import { Link } from "react-router-dom";
import "./Dashboard.css";

function Dashboard() {
    return (
        <div className="dashboard">
            <div className="dashboard-hero">
                <h1 className="dashboard-title">📰 News Portal</h1>
                <p className="dashboard-subtitle">
                    React API Integration — Fetch, Axios & Local JSON
                </p>
            </div>

            <div className="dashboard-cards">
                <Link to="/local-users" className="dash-card card-local">
                    <div className="card-icon">📂</div>
                    <h2>Local Users</h2>
                    <p>Fetch &amp; display users from a local <code>users.json</code> file using the Fetch API.</p>
                    <span className="card-badge">fetch() + Local JSON</span>
                </Link>

                <Link to="/users-api" className="dash-card card-api">
                    <div className="card-icon">🌐</div>
                    <h2>Users API</h2>
                    <p>Fetch real user data from JSONPlaceholder public REST API using fetch().</p>
                    <span className="card-badge">fetch() + JSONPlaceholder</span>
                </Link>

                <Link to="/fake-posts" className="dash-card card-fake">
                    <div className="card-icon">🗞️</div>
                    <h2>Fake API Posts</h2>
                    <p>Load posts from DummyJSON using Axios with filter &amp; refresh support.</p>
                    <span className="card-badge">axios + DummyJSON</span>
                </Link>
            </div>
        </div>
    );
}

export default Dashboard;
