import { faHeart as farHeart } from "@fortawesome/free-regular-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

import { Link } from "react-router-dom";
import "./wishList.css";

function WishList() {
  return (
    <div className="wishlist-container">
      <Link to="/wishlist">
        <FontAwesomeIcon icon={farHeart} style={{ fontSize: "24px" }} />
      </Link>
      <div className="wishlist-count">2</div>
    </div>
  );
}

export default WishList;
