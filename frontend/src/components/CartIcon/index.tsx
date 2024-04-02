import { faShoppingCart } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { useContext } from "react";
import { Link } from "react-router-dom";
import { ContextCartCount } from "../../utils/context-cart";
import "./cartIcon.css";

function CartIcon() {

  const { contextCartCount, setContextCartCount } =
    useContext(ContextCartCount);

  return (
    <div className="cart-container">
      <Link to="/cart">
        <FontAwesomeIcon icon={faShoppingCart} style={{ fontSize: "24px" }} />

        {contextCartCount > 0 && (
          <div className="cartcount">{contextCartCount}</div>
        )}

      </Link>
    </div>
  );
}

export default CartIcon;
