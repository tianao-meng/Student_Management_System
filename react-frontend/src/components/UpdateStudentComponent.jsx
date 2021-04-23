import React, { Component } from "react";
import StudentService from "../services/StudentService";

class UpdateStudentComponent extends Component {
  state = {
    id: this.props.match.params.id,
    firstName: "",
    lastName: "",
    emailId: "",
  };

  componentDidMount() {
    StudentService.getStudentById(this.state.id).then((res) => {
      let student = res.data;
      console.log(student);
      this.setState({
        firstName: student.firstName,
        lastName: student.lastName,
        emailId: student.emailId,
      });
    });
  }

  chaneFirstNameHandler = (e) => {
    this.setState({ firstName: e.target.value });
  };

  chaneLastNameHandler = (e) => {
    this.setState({ lastName: e.target.value });
  };

  changeEmailHandler = (e) => {
    this.setState({ emailId: e.target.value });
  };

  updateStudent = (e) => {
    e.preventDefault();
    let student = {
      firstName: this.state.firstName,
      lastName: this.state.lastName,
      emailId: this.state.emailId,
    };

    StudentService.updateStudent(student, this.state.id).then((res) => {
      this.props.history.push("/students");
    });
    console.log(student);
  };

  cancel = () => {
    this.props.history.push("/students");
  };

  render() {
    return (
      <div>
        <div className="container">
          <div className="row">
            <div className="card col-md-6 offset-md-3 offset-md-3">
              <h3 className="text-center">Update Student</h3>
              <div className="card-body">
                <form>
                  <div className="form-group">
                    <label>First Name: </label>
                    <input
                      placeholder="First Name"
                      name="firstName"
                      className="form-control"
                      value={this.state.firstName}
                      onChange={this.chaneFirstNameHandler}
                    />
                  </div>
                  <div className="form-group">
                    <label>Last Name: </label>
                    <input
                      placeholder="Last Name"
                      name="lastName"
                      className="form-control"
                      value={this.state.lastName}
                      onChange={this.chaneLastNameHandler}
                    />
                  </div>
                  <div className="form-group">
                    <label>Email Id: </label>
                    <input
                      placeholder="Email Address"
                      name="emailId"
                      className="form-control"
                      value={this.state.emailId}
                      onChange={this.changeEmailHandler}
                    />
                  </div>

                  <button
                    className="btn btn-success"
                    onClick={this.updateStudent}
                  >
                    Save
                  </button>

                  <button
                    className="btn btn-danger"
                    onClick={this.cancel}
                    style={{ marginLeft: "10px" }}
                  >
                    Cancel
                  </button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default UpdateStudentComponent;
