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
import { PrivateRoute } from "./components/Private";
import { AccessTokenPayLoadDTO } from "./models/auth";
import { ContextToken } from "./utils/context-token";
import * as authService from "./services/auth-service"


function App() {

  const [contextCartCount, setContextCartCount] = useState<number>(0);

  const [contextTokenPayload, setContextTokenPayload] = useState<AccessTokenPayLoadDTO>();

  useEffect(() => {

    setContextCartCount(cartService.getCart().items.length)

    if (authService.isAuthenticated()) {3
      const payload = authService.getAccessTokenPayload();
      setContextTokenPayload(payload);
    }
  }, []);

  return (
    <ContextToken.Provider value={{ contextTokenPayload, setContextTokenPayload }}>
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
            <Route path="/admin" element={
              <PrivateRoute roles={["ROLE_ADMIN"]}>
                <Admin />
              </PrivateRoute>
            }>
              <Route index element={<AdminHome />} />
            </Route>
          </Routes>
        </HistoryRouter>
      </ContextCartCount.Provider>
    </ContextToken.Provider>
  );
}

export default App;
