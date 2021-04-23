import React, { Component } from "react";
import StudentService from "../services/StudentService";

class ListStudentComponent extends Component {
  state = {
    students: [],
  };

  componentDidMount() {
    StudentService.getStudent().then((res) => {
      this.setState({ students: res.data });
    });
  }

  addStudent = () => {
    //console.log(this);
    this.props.history.push("./add-student/_add");
  };

  editStudent = (id) => {
    this.props.history.push(`/add-student/${id}`);
  };

  deleteStudent = (id) => {
    StudentService.deleteStudent(id).then((res) => {
      this.setState({
        students: this.state.students.filter((student) => student.id !== id),
      });
    });
  };

  viewStudent = (id) => {
    this.props.history.push(`/view-student/${id}`);
  };

  render() {
    return (
      <div className="container">
        <h2 className="text-center">Student List</h2>
        <div className="row">
          <button className="btn btn-dark" onClick={this.addStudent}>
            Add Student
          </button>
        </div>
        <div className="row">
          <table className="table table-striped table-bordered">
            <thead>
              <tr>
                <th>Student First Name</th>
                <th>Student Last Name</th>
                <th>Student Email Id</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {this.state.students.map((student) => (
                <tr key={student.id}>
                  <td>{student.firstName}</td>
                  <td>{student.lastName}</td>
                  <td>{student.emailId}</td>
                  <td>
                    <button
                      onClick={() => this.editStudent(student.id)}
                      className="btn btn-info"
                    >
                      Update
                    </button>

                    <button
                      onClick={() => this.deleteStudent(student.id)}
                      className="btn btn-danger"
                      style={{ marginLeft: "10px" }}
                    >
                      Delete
                    </button>

                    <button
                      onClick={() => this.viewStudent(student.id)}
                      className="btn btn-info"
                      style={{ marginLeft: "10px" }}
                    >
                      View
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    );
  }
}

export default ListStudentComponent;
