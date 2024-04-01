import { faSignInAlt } from "@fortawesome/free-solid-svg-icons"
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome"
import { Link } from "react-router-dom"
import WishList from "../WishList"
import CartIcon from "../CartIcon"

function HeaderNavbarRight() {
    return (
        <nav>
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
    )
}

export default HeaderNavbarRight
