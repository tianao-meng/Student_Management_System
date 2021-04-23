import React, { Component } from "react";

class HeaderComponent extends Component {
  render() {
    return (
      <div>
        <header>
          <nav className="navbar navbar-dark bg-dark">
            <a className="navbar-brand" href="">
              Waterloo Student ManageMent App
            </a>
          </nav>
        </header>
      </div>
    );
  }
}

export default HeaderComponent;
