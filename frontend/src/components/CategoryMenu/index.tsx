import { faBars, faClose } from "@fortawesome/free-solid-svg-icons";
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
        <div className="offcanvas-header " style={{
          backgroundImage: "linear-gradient(to bottom, #fdd835, #fbc12d)", // Gradiente linear como fundo amarelo
          color: "black" // Texto preto
        }}>
          <h5 className="offcanvas-title" id="offcanvasWithBothOptionsLabel">
            Escolha os produtos por categoria
          </h5>
          <button onClick={closeOffcanvas}>
            <FontAwesomeIcon icon={faClose} />
          </button>
        </div>
        <div className="offcanvas-body" style={{ background: "#f0f0f0" }}> {/* Cor de fundo cinza claro */}
          <p>
            s
          </p>
        </div>
      </div>
    </div>
  );
}

export default CategoryMenu;
