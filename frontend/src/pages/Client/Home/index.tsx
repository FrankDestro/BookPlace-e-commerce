import { Outlet } from "react-router-dom";
import Footer from "../../../components/Footer";
import HeaderClient from "../../../components/HeaderClient";
import FooterCertification from "../../../components/FooterCertification";

import "./styles.css";
import HeaderNavbarRight from "../../../components/HeaderNavbarRight";

function ClientHome() {
  return (
    <div>
      <HeaderClient />
      <Outlet />
      <FooterCertification />

      <Footer />
      <div className="navbar-right-mobile">
        <HeaderNavbarRight/>
      </div>
    </div>
  );
}

export default ClientHome;
