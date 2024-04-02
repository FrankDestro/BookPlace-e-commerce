import { useEffect, useState } from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Cart from "./pages/Client/Cart";
import Catalog from "./pages/Client/Catalog";
import ClientHome from "./pages/Client/Home";
import Login from "./pages/Client/Login";
import Payment from "./pages/Client/Payment";
import ProductDetails from "./pages/Client/ProductDetails";
import * as cartService from "./services/cart-service";
import { ContextCartCount } from "./utils/context-cart";


function App() {

  const [contextCartCount, setContextCartCount] = useState<number>(0);

  useEffect(() => {
    setContextCartCount(cartService.getCart().items.length)
  }, [])

  return (
    <ContextCartCount.Provider value={{ contextCartCount, setContextCartCount }}>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<ClientHome />}>
            <Route index element={<Catalog />} />
            <Route path="cart" element={<Cart />} />
            <Route path="productdetails/:productId" element={<ProductDetails />} />
            <Route path="payment" element={<Payment />} />
            <Route path="login" element={<Login />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </ContextCartCount.Provider>
  );
}

export default App;
