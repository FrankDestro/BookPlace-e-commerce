import { faBars } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { useState } from "react";

import "./categoryMenu.css";

function CategoryMenu() {
  const [isOffcanvasOpen, setIsOffcanvasOpen] = useState(false);

  const openOffcanvas = () => {
    setIsOffcanvasOpen(true);
  };

  const closeOffcanvas = () => {
    setIsOffcanvasOpen(false);
  };

  return (
    <div>
      <button className="btn btn-icon" type="button" onClick={openOffcanvas}>
        <FontAwesomeIcon icon={faBars} />
      </button>

      {isOffcanvasOpen && (
        <div className="overlay" onClick={closeOffcanvas}></div>
      )}

      <div
        className={`offcanvas offcanvas-start ${isOffcanvasOpen ? "show" : ""}`}
        data-bs-scroll="true"
        tabIndex={-1}
        id="offcanvasWithBothOptions"
        aria-labelledby="offcanvasWithBothOptionsLabel"
      >
        <div className="offcanvas-header">
          <h5 className="offcanvas-title" id="offcanvasWithBothOptionsLabel">
            Backdrop with scrolling
          </h5>
          <button
            type="button"
            className="btn-close"
            onClick={closeOffcanvas}
            aria-label="Close"
          ></button>
        </div>
        <div className="offcanvas-body">
          <p>
            Try scrolling the rest of the page to see this option in action.
          </p>
        </div>
      </div>
    </div>
  );
}

export default CategoryMenu;
