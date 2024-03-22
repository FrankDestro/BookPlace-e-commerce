import { faShoppingCart } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

import "./cartIcon.css";
import { Link } from "react-router-dom";

function CartIcon() {
  return (
    <div className="cart-container">
      <Link to="/cart">
        <FontAwesomeIcon icon={faShoppingCart} style={{ fontSize: "24px" }} />
        <div className="cartcount">2</div>
      </Link>
    </div>
  );
}

export default CartIcon;
