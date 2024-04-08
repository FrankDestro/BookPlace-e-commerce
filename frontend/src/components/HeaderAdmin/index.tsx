import { Link } from "react-router-dom";
import bookIcon from "../../assets/img/logobook.png";
import HeaderAdminNavbarRight from "../HeaderAdminNavbarRight";
import "./HeaderAdmin.css";

function HeaderAdmin() {
  return (
    <>
      <header className="book-header-admin">
        <nav className="book-container">
          <Link to="/">
            <img
              src={bookIcon}
              alt="book"
              style={{ width: "50px", height: "50px" }}
            />
            <h1>BookPlace</h1>
          </Link>
          <div className="container-navbar-right">
            <HeaderAdminNavbarRight />
          </div>
        </nav>
      </header>
    </>
  );
}

export default HeaderAdmin;
