import { useState } from 'react'
import './StudentManager.css'

function StudentManager() {
    const [students, setStudents] = useState([])
    const [newStudent, setNewStudent] = useState({ id: '', name: '', course: '' })

    // Handle input changes and update newStudent object
    const handleChange = (e) => {
        const { name, value } = e.target
        setNewStudent((prev) => ({ ...prev, [name]: value }))
    }

    // Add newStudent to the students array, then clear the input fields
    const handleAdd = () => {
        if (!newStudent.id || !newStudent.name || !newStudent.course) {
            alert('Please fill in all fields before adding a student.')
            return
        }
        const isDuplicate = students.some(
            (s) => String(s.id) === String(newStudent.id)
        )
        if (isDuplicate) {
            alert(`A student with ID "${newStudent.id}" already exists.`)
            return
        }
        setStudents((prev) => [...prev, { ...newStudent }])
        setNewStudent({ id: '', name: '', course: '' })
    }

    // Remove a student by id
    const handleDelete = (id) => {
        setStudents((prev) => prev.filter((s) => String(s.id) !== String(id)))
    }

    return (
        <div className="sm-container">
            {/* Header */}
            <header className="sm-header">
                <div className="sm-header-icon">🎓</div>
                <div>
                    <h1 className="sm-title">Student Manager</h1>
                    <p className="sm-subtitle">Online Academic Portal</p>
                </div>
            </header>

            {/* Add Student Form */}
            <section className="sm-form-section">
                <h2 className="sm-section-title">Add New Student</h2>
                <div className="sm-form">
                    <div className="sm-field">
                        <label htmlFor="id">Student ID</label>
                        <input
                            id="id"
                            type="text"
                            name="id"
                            placeholder="e.g. 101"
                            value={newStudent.id}
                            onChange={handleChange}
                        />
                    </div>
                    <div className="sm-field">
                        <label htmlFor="name">Full Name</label>
                        <input
                            id="name"
                            type="text"
                            name="name"
                            placeholder="e.g. John Doe"
                            value={newStudent.name}
                            onChange={handleChange}
                        />
                    </div>
                    <div className="sm-field">
                        <label htmlFor="course">Course</label>
                        <input
                            id="course"
                            type="text"
                            name="course"
                            placeholder="e.g. Computer Science"
                            value={newStudent.course}
                            onChange={handleChange}
                        />
                    </div>
                    <button className="btn btn-add" onClick={handleAdd}>
                        ＋ Add Student
                    </button>
                </div>
            </section>

            {/* Student List */}
            <section className="sm-list-section">
                <h2 className="sm-section-title">
                    Student List
                    <span className="sm-badge">{students.length}</span>
                </h2>

                {students.length === 0 ? (
                    <div className="sm-empty">
                        <span className="sm-empty-icon">📭</span>
                        <p>No students available</p>
                    </div>
                ) : (
                    <div className="sm-table-wrapper">
                        <table className="sm-table">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Course</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                {students.map((student, index) => (
                                    <tr key={student.id} className="sm-row">
                                        <td className="sm-serial">{index + 1}</td>
                                        <td className="sm-id">{student.id}</td>
                                        <td className="sm-name">{student.name}</td>
                                        <td className="sm-course">
                                            <span className="sm-course-badge">{student.course}</span>
                                        </td>
                                        <td>
                                            <button
                                                className="btn btn-delete"
                                                onClick={() => handleDelete(student.id)}
                                            >
                                                🗑 Delete
                                            </button>
                                        </td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </div>
                )}
            </section>
        </div>
    )
}

export default StudentManager
