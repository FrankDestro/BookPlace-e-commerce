import { faCheckCircle, faWarning } from '@fortawesome/free-solid-svg-icons';
import { faCartPlus } from '@fortawesome/free-solid-svg-icons/faCartPlus';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { useContext, useEffect, useState } from 'react';
import { Toast } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import 'react-toastify/dist/ReactToastify.css';
import { ProductDTO } from '../../models/product';
import * as CartService from "../../services/cart-service";
import { ContextCartCount } from '../../utils/context-cart';


type Props = {
  product: ProductDTO;
};

function CatalogCardBook({ product }: Props) {

  const { setContextCartCount } = useContext(ContextCartCount);

  const [showToast, setShowToast] = useState<boolean | string>(false); // Modifique o tipo do estado

  function handleBuyClick() {

    const cart = CartService.getCart();

    const isProductInCart = cart.items.some(item => item.productId === product.id);

    if (isProductInCart) {
      setShowToast("Este produto já está no carrinho.");
    } else {
      CartService.addProduct(product);
      setContextCartCount(cart.items.length + 1);
      setShowToast("Produto adicionado ao carrinho com sucesso.");
    }
  }

  useEffect(() => {
    let timer: number | undefined;
    if (showToast) {
      timer = setTimeout(() => {
        setShowToast(false);
      }, 3000);
    }
    return () => clearTimeout(timer);
  }, [showToast]);


  return (
    <div>
      <div className="relative m-10 flex w-full max-w-xs flex-col overflow-hidden rounded-lg border border-gray-100 bg-gray shadow-md">

        <a className="relative mx-3 mt-3 flex h-60 overflow-hidden rounded-xl justify-center" href={`/productdetails/${product.id}`}>
          <img
            className="object-cover"
            src={product.productImages[0].imageUrl}
            alt="product image"
          />
          <span className="absolute top-0 left-0 m-2 rounded-full bg-black px-2 text-center text-sm font-medium text-white">
            39% OFF
          </span>
        </a>
        <div className="mt-4 px-3 pb-4">
          <Link to={`/productdetails/${product.id}`}>
            <h5 className="text-xl tracking-tight text-slate-900">
              {product.name}
            </h5>
          </Link>
          <div className="mt-3 mb-4 flex flex-col  justify-between">
            <p>
              <span className="text-3xl font-bold text-black-900">R$ {product.cashPrice},00</span>
              <span className="text-sm text-slate-900 line-through">R$ {product.price}</span>
            </p>
            <div className="flex items-center mt-2">
              <svg
                aria-hidden="true"
                className="h-5 w-5 text-yellow-300"
                fill="currentColor"
                viewBox="0 0 20 20"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z"></path>
              </svg>
              <svg
                aria-hidden="true"
                className="h-5 w-5 text-yellow-300"
                fill="currentColor"
                viewBox="0 0 20 20"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z"></path>
              </svg>
              <svg
                aria-hidden="true"
                className="h-5 w-5 text-yellow-300"
                fill="currentColor"
                viewBox="0 0 20 20"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z"></path>
              </svg>
              <svg
                aria-hidden="true"
                className="h-5 w-5 text-yellow-300"
                fill="currentColor"
                viewBox="0 0 20 20"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z"></path>
              </svg>
              <svg
                aria-hidden="true"
                className="h-5 w-5 text-yellow-300"
                fill="currentColor"
                viewBox="0 0 20 20"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z"></path>
              </svg>
              <span className="mr-2 ml-3 rounded bg-yellow-500 px-2.5 py-0.5 text-xs font-semibold">
                5.0
              </span>
            </div>
          </div>

          <div className="flex items-center justify-center rounded-md bg-yellow-300 px-5 py-2.5 text-center text-sm font-medium text-black hover:bg-yellow-200 focus:outline-none focus:ring-4 focus:ring-blue-300">
            <FontAwesomeIcon
              icon={faCartPlus}
              style={{ marginRight: "10px", fontSize: "18px" }}
            />
            <button type="button" onClick={handleBuyClick}>
              Adicionar ao carrinho
            </button>

            <Toast show={typeof showToast === "string"} onClose={() => setShowToast(false)} className="position-fixed top-0 end-0 m-4" style={{ zIndex: 9999 }}>
              <Toast.Header closeButton={false}>
                {typeof showToast === "string" && showToast.includes("sucesso") ? (
                  <FontAwesomeIcon icon={faCheckCircle} className="me-2 text-success" />
                ) : (
                  <FontAwesomeIcon icon={faWarning} className="me-2 text-warning" />
                )}
                <strong className="me-auto">{typeof showToast === "string" && showToast.includes("sucesso") ? "Sucesso!" : "Aviso"}</strong>
              </Toast.Header>
              <Toast.Body>{typeof showToast === "string" && showToast}</Toast.Body>
            </Toast>

          </div>
        </div>
      </div>
    </div>
  );
}

export default CatalogCardBook;
