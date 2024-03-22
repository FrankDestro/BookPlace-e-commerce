import ebit from "../../assets/img/ebit-diamante.png";
import siteBlindado from "../../assets/img/site-blindado.svg";
import browsingSafe from "../../assets/img/safebrowsing.png";
import reclameSelo from "../../assets/img/selo_reclame.png";

import "./styles.css";

function FooterCertification() {
  return (
    <div className="footer-security-main">
      <footer className="py-4 my-3">
        <ul className="nav justify-content-center pb-3 mb-3 container-img">
          <li className="nav-item">
            <a href="#" className="nav-link px-2 text-body-secondary ebit-img">
              <img src={ebit} alt="ebit" />
            </a>
          </li>
          <li className="nav-item">
            <a href="#" className="nav-link px-2 text-body-secondary">
              <img src={siteBlindado} alt="ebit" />
            </a>
          </li>
          <li className="nav-item">
            <a href="#" className="nav-link px-2 text-body-secondary">
              <img src={browsingSafe} alt="browsingSafe" />
            </a>
          </li>
          <li className="nav-item">
            <a href="#" className="nav-link px-2 text-body-secondary">
              <img src={reclameSelo} alt="reclameSelo" />
            </a>
          </li>
          <li className="nav-item">
            <a href="#" className="nav-link px-2 text-body-secondary">
              <img src={reclameSelo} alt="reclameSelo" />
            </a>
          </li>
        </ul>
      </footer>
    </div>
  );
}

export default FooterCertification;
