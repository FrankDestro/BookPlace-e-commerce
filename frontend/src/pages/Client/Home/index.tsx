import { Outlet } from "react-router-dom";
import Footer from "../../../components/Footer";
import FooterCertification from "../../../components/FooterCertification";
import HeaderClient from "../../../components/HeaderClient";
import HeaderNavbarRight from "../../../components/HeaderNavbarRight";
import "./styles.css";

function ClientHome() {
  return (
    <div>
      <HeaderClient />
      <Outlet />
      <FooterCertification />
      <Footer />
      <div className="navbar-right-mobile">
        <HeaderNavbarRight />
      </div>
    </div>
  );
}

export default ClientHome;
