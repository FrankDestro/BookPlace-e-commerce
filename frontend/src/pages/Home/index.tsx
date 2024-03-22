import { Outlet } from "react-router-dom";
import Footer from "../../components/Footer";
import HeaderClient from "../../components/HeaderClient";

function ClientHome() {
  return (
    <div>
      <HeaderClient />
      <Outlet />
      <Footer/>
    </div>
  );
}

export default ClientHome;
