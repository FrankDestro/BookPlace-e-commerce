import { useEffect, useState } from "react";
import { unstable_HistoryRouter as HistoryRouter, Route, Routes } from "react-router-dom";
import Admin from "./pages/Admin";
import AdminHome from "./pages/Admin/Home";
import Cart from "./pages/Client/Cart";
import Catalog from "./pages/Client/Catalog";
import ClientHome from "./pages/Client/Home";
import Login from "./pages/Client/Login";
import Payment from "./pages/Client/Payment";
import ProductDetails from "./pages/Client/ProductDetails";
import * as cartService from "./services/cart-service";
import { ContextCartCount } from "./utils/context-cart";
import { history } from "./utils/history";


function App() {

  const [contextCartCount, setContextCartCount] = useState<number>(0);

  useEffect(() => {
    setContextCartCount(cartService.getCart().items.length)
  }, [])

  return (
    <ContextCartCount.Provider value={{ contextCartCount, setContextCartCount }}>
      <HistoryRouter history={history}>
        <Routes>
          <Route path="/" element={<ClientHome />}>
            <Route index element={<Catalog />} />
            <Route path="cart" element={<Cart />} />
            <Route path="productdetails/:productId" element={<ProductDetails />} />
            <Route path="payment" element={<Payment />} />
            <Route path="login" element={<Login />} />
          </Route>
          <Route path="/admin" element={<Admin />}>
            <Route index element={<AdminHome />} />
          </Route>
        </Routes>
      </HistoryRouter>
    </ContextCartCount.Provider>
  );
}

export default App;
