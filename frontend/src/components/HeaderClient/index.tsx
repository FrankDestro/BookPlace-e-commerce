import { Link } from "react-router-dom";
import bookIcon from "../../assets/img/logobook.png";
import CategoryMenu from "../CategoryMenu";
import "./HeaderClient.css";
import HeaderNavbarRight from "../HeaderNavbarRight";

function HeaderClient() {
  return (
    <>
      <header className="book-header-client">
        <nav className="book-container">
          <Link to="/">
            <img
              src={bookIcon}
              alt="book"
              style={{ width: "50px", height: "50px" }}
            />
            <h1>BookPlace</h1>
            <div className="container-menu-categories">
              <h1>
                <CategoryMenu />
              </h1>
              <h3>departamentos</h3>
            </div>
          </Link>
          <div className="container-navbar-right">
            <HeaderNavbarRight />
          </div>
        </nav>
      </header>
    </>
  );
}

export default HeaderClient;
