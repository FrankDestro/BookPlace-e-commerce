import { BrowserRouter, Route, Routes } from "react-router-dom";
import Catalog from "./pages/Client/Catalog";
import ClientHome from "./pages/Client/Home";
import Cart from "./pages/Client/Cart";
import ProductDetails from "./pages/Client/ProductDetails";
import Payment from "./pages/Client/Payment";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<ClientHome />}>
          <Route index element={<Catalog />} />
          <Route path="cart" element={<Cart />} />
          <Route path="productdetails/:productId" element={<ProductDetails />}/>
          <Route path="payment" element={<Payment/>} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
