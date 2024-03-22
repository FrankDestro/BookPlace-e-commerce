import { faSignInAlt } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { Link } from "react-router-dom";
import bookIcon from "../../assets/img/logobook.png";
import CartIcon from "../CartIcon";
import CategoryMenu from "../CategoryMenu";
import WishList from "../WishList";
import "./HeaderClient.css";

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

          <div className="book-navbar-right">
            <div>
              <Link to="/login">
                <FontAwesomeIcon
                  icon={faSignInAlt}
                  style={{ fontSize: "24px", marginRight: "10px" }}
                />
              </Link>
            </div>

            <div>
              <WishList />
            </div>

            <div>
              <CartIcon />
            </div>
          </div>
        </nav>
      </header>
    </>
  );
}

export default HeaderClient;
