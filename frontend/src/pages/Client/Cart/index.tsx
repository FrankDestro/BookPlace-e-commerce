import {
  faArrowRight,
  faShoppingCart,
  faTrash,
} from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { useState } from "react";
import { OrderDTO } from "../../../models/order";
import * as cartService from "../../../services/cart-service";
import CartEmpty from "../../CartEmpty";
import "./styles.css";

function Cart() {
  
  const [cart, setCart] = useState<OrderDTO>(cartService.getCart());

  function handleClearClick() {
    cartService.clearCart();
    const newCart = cartService.getCart();
    setCart(newCart);
  }

  function handelIncreaseItem(productId: number) {
    cartService.increaseItem(productId);
    setCart(cartService.getCart());
  }

  function handelDecreaseItem(productId: number) {
    cartService.decreaseItem(productId);
    const newCart = cartService.getCart();
    setCart(newCart);
  }

  function handleRemoveItem(productId: number)  {
    cartService.removeItem(productId);
    const newCart = cartService.getCart();
    setCart(newCart);
  }
  
  return (
    <div>
      <section className="book-container" id="catalog-section">
        <div className="mx-auto px-4 sm:px-6 lg:px-8">
          <div className="flex items-center">
            <div style={{ marginRight: "10px" }}></div>
            <FontAwesomeIcon
              icon={faShoppingCart}
              style={{ marginRight: "10px", fontSize: "24px" }}
            />
            <h1 className="text-2xl font-semibold text-gray-900">Carrinho</h1>
          </div>

          <div className="mx-auto mt-8 md:mt-12">
            <div className="bg-white shadow border border-gray-200">
              <div className="px-4 py-6 sm:px-8 sm:py-10">
                <div className="flow-root">

                  <ul className="-my-8">

                    {cart.items && cart.items.length > 0 ? (
                      cart.items.map((item) => (

                        <li className="flex flex-col space-y-3 py-6 text-left border-b sm:flex-row sm:space-x-5 sm:space-y-0" key={item.productId}>
                          <div className="img-product">
                            <img src={item.imgUrl} alt="book" />
                          </div>
                          <div className="relative flex flex-1 flex-col justify-between">
                            <div className="sm:col-gap-5 sm:grid sm:grid-cols-2">
                              <div className="pr-8 sm:pr-5">
                                <p className="text-base font-semibold text-gray-900">
                                  {item.name}
                                </p>
                                <p className="mx-0 mt-1 mb-0 text-sm text-gray-400">
                                  36EU - 4US
                                </p>
                              </div>
                              <div className="mt-4 flex items-end justify-between sm:mt-0 sm:items-start sm:justify-end">
                                <p className="shrink-0 w-20 text-base font-semibold text-gray-900 sm:order-2 sm:ml-8 sm:text-right">
                                  R$ {item.price}
                                </p>
                                <div className="sm:order-1">
                                  <div className="mx-auto flex h-8 items-stretch text-gray-600">
                                    <button className="flex items-center justify-center rounded-l-md bg-gray-200 px-4 transition hover:bg-black hover:text-white"
                                      onClick={() => handelDecreaseItem(item.productId)}
                                    >
                                      -
                                    </button>
                                    <div className="flex w-full items-center justify-center bg-gray-100 px-4 text-xs uppercase transition">
                                      {item.quantity}
                                    </div>
                                    <button className="flex items-center justify-center rounded-r-md bg-gray-200 px-4 transition hover:bg-black hover:text-white"
                                      onClick={() => handelIncreaseItem(item.productId)}
                                    >
                                      +
                                    </button>
                                  </div>
                                </div>
                              </div>
                            </div>
                            <div className="absolute top-0 right-0 flex sm:bottom-0 sm:top-auto">
                              <button
                                type="button"
                                className="flex rounded p-2 text-center text-gray-500 transition-all duration-200 ease-in-out focus:shadow hover:text-gray-900">
                                <FontAwesomeIcon icon={faTrash}  
                                onClick={() => handleRemoveItem(item.productId)} 
                                />
                              </button>
                            </div>
                          </div>
                        </li>
                      ))) : (
                        <CartEmpty/>                      
                    )}

                  </ul>
                </div>

                <div className="mt-6 border-t border-b py-2">
                  <div className="flex items-center justify-between">
                    <p className="text-sm text-black-900">Subtotal</p>
                    <p className="text-lg font-semibold text-black-900">
                      R$ 78,80
                    </p>
                  </div>
                  <div className="flex items-center justify-between">
                    <p className="text-sm text-black-900">Frete</p>
                    <p className="text-lg font-semibold text-gray-900">
                      R$ 8.00
                    </p>
                  </div>
                </div>
                <div className="mt-6 flex items-center justify-between">
                  <p className="text-sm font-medium text-gray-900">Total</p>
                  <p className="text-2xl font-bold text-gray-900">
                    <span className="text-xs font-bold text-black-900 mr-2">
                      R$
                    </span>
                    86,80
                  </p>
                </div>

                <div className="mt-6 text-center">
                  <button
                    type="button"
                    className="group inline-flex w-full items-center justify-center rounded-md bg-yellow-500 px-6 py-4 text-lg font-semibold text-black transition-all duration-200 ease-in-out focus:shadow hover:bg-yellow-600"
                  >
                    Ir para pagamento
                    <FontAwesomeIcon
                      icon={faArrowRight}
                      style={{ marginLeft: "10px" }}
                    />
                  </button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
  );
  1;
}

export default Cart;
