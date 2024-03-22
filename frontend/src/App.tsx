import { BrowserRouter, Route, Routes } from "react-router-dom";
import Catalog from "./pages/Catalog";
import ClientHome from "./pages/Home";
import Cart from "./pages/Cart";
import ProductDetails from "./pages/ProductDetails";
import Payment from "./pages/Payment";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<ClientHome />}>
          <Route index element={<Catalog />} />
          <Route path="cart" element={<Cart />} />
          <Route path="productdetails" element={<ProductDetails />} />
          <Route path="payment" element={<Payment/>} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
