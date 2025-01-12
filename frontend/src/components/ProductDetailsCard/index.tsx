import { faCartPlus } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { SetStateAction, useContext, useState } from "react";
import { useNavigate } from "react-router-dom";
import { ProductDTO } from "../../models/product";
import * as CartService from "../../services/cart-service";
import { ContextCartCount } from "../../utils/context-cart";
import "./styles.css";

type Props = {
  product: ProductDTO;
};

function ProductDetailsCard({ product }: Props) {

  const navigate = useNavigate();

  const { setContextCartCount } = useContext(ContextCartCount);

  const [mainImage, setMainImage] = useState(product.productImages[0].imageUrl);

  const handleImageClick = (imageUrl: SetStateAction<string>) => {
    setMainImage(imageUrl);
  };

  const [isModalOpen, setIsModalOpen] = useState(false);

  const openModal = () => {
    setIsModalOpen(true);
  };

  const closeModal = () => {
    setIsModalOpen(false);
  };

  function handleBuyClick() {
    if (product) {
      CartService.addProduct(product);
      setContextCartCount(CartService.getCart().items.length)
      navigate("/cart");
    }
  }

  return (
    <div className="font-[sans-serif]">
      <div className="p-6 lg:max-w-6xl max-w-2xl mx-auto">
        <div className="grid items-start grid-cols-1 lg:grid-cols-2 gap-8">

          <div className="w-full lg:sticky top-0 sm:flex gap-2">

            <div className="sm:space-y-3 w-16 max-sm:flex max-sm:mb-4 max-sm:gap-4" style={{ marginRight: "20px" }}>
              {product.productImages.map((image) => (
                <img
                  key={image.id}
                  src={image.imageUrl}
                  alt="Image"
                  className="w-full cursor-pointer outline"
                  onClick={() => handleImageClick(image.imageUrl)}
                />
              ))}
            </div>

            <div>
              <img
                src={mainImage}
                alt="Product"
                className="w-4/5 rounded object-cover cursor-pointer"
                onClick={openModal}
              />
              {isModalOpen && (
                <div className="fixed top-0 left-0 w-full h-full flex justify-center items-center bg-black bg-opacity-50 z-50">
                  <div className="max-w-md w-full bg-black bg-opacity-50 rounded-lg p-1 relative">
                    <img
                      src={mainImage}
                      alt="Product"
                      className="w-full rounded object-cover"
                    />
                    <button
                      className="absolute top-4 right-4 text-black-600 hover:text-gray-800 font-bold right-400"
                      onClick={closeModal}
                    >
                      Fechar
                    </button>
                  </div>
                </div>
              )}
            </div>
          </div>

          <div>
            <h2 className="text-2xl font-extrabold text-gray-800">{product.name}</h2>
            <div className="flex flex-wrap gap-3 mt-4">
              <p className="text-gray-800 text-5xl font-bold">R$ {product.cashPrice.toFixed(2)} </p>
              <p className="text-green-400 text-xl font-bold"> PIX </p>
            </div>
            <div className="flex flex-wrap gap-3 mt-4">
              <p className="text-gray-800 text-3xl font-bold">R$ {product.price.toFixed(2)} </p>
              <p className="text-gray-500 text-1xl"> Boleto / Cartão Credito </p>
            </div>

            <div className="flex space-x-2 mt-4">
              <p className="text-gray-500 text-1xl"> Análise </p>
              <svg className="w-5 fill-yellow-400" viewBox="0 0 14 13" fill="none"
                xmlns="http://www.w3.org/2000/svg">
                <path
                  d="M7 0L9.4687 3.60213L13.6574 4.83688L10.9944 8.29787L11.1145 12.6631L7 11.2L2.8855 12.6631L3.00556 8.29787L0.342604 4.83688L4.5313 3.60213L7 0Z" />
              </svg>
              <svg className="w-5 fill-yellow-400" viewBox="0 0 14 13" fill="none"
                xmlns="http://www.w3.org/2000/svg">
                <path
                  d="M7 0L9.4687 3.60213L13.6574 4.83688L10.9944 8.29787L11.1145 12.6631L7 11.2L2.8855 12.6631L3.00556 8.29787L0.342604 4.83688L4.5313 3.60213L7 0Z" />
              </svg>
              <svg className="w-5 fill-yellow-400" viewBox="0 0 14 13" fill="none"
                xmlns="http://www.w3.org/2000/svg">
                <path
                  d="M7 0L9.4687 3.60213L13.6574 4.83688L10.9944 8.29787L11.1145 12.6631L7 11.2L2.8855 12.6631L3.00556 8.29787L0.342604 4.83688L4.5313 3.60213L7 0Z" />
              </svg>
              <svg className="w-5 fill-yellow-400" viewBox="0 0 14 13" fill="none"
                xmlns="http://www.w3.org/2000/svg">
                <path
                  d="M7 0L9.4687 3.60213L13.6574 4.83688L10.9944 8.29787L11.1145 12.6631L7 11.2L2.8855 12.6631L3.00556 8.29787L0.342604 4.83688L4.5313 3.60213L7 0Z" />
              </svg>
              <svg className="w-5 fill-[#CED5D8]" viewBox="0 0 14 13" fill="none"
                xmlns="http://www.w3.org/2000/svg">
                <path
                  d="M7 0L9.4687 3.60213L13.6574 4.83688L10.9944 8.29787L11.1145 12.6631L7 11.2L2.8855 12.6631L3.00556 8.29787L0.342604 4.83688L4.5313 3.60213L7 0Z" />
              </svg>
            </div>
            <div className="mt-8">
              <h3 className="text-lg font-bold text-gray-800">Categoria</h3>
              <div className="flex flex-wrap gap-4 mt-4">

                {product.categories.map((item) => (
                  <div className="custom-div"> <span className="initials"> {item.name} </span> </div>
                ))
                }

              </div>
              <button type="button"
                className="w-full mt-4 px-4 py-3 bg-yellow-500 hover:bg-yellow-600 text-black font-bold rounded"
                onClick={handleBuyClick}
              >
                <FontAwesomeIcon icon={faCartPlus} style={{ marginRight: "10px" }} />
                Adicionar ao carrinho
              </button>
            </div>
            <div className="mt-8">
              <h3 className="text-lg font-bold text-gray-800" style={{ borderBottom: "1px solid gray" }}>Descrição</h3>
              <ul className="space-y-3 list-disc mt-4 pl-4 text-sm text-gray-800">
                <p>
                  {product.description}
                </p>
              </ul>
            </div>
            <div className="mt-8">
              <h3 className="text-lg font-bold text-gray-800" style={{ borderBottom: "1px solid gray" }}>Detalhes</h3>
              <ul className="space-y-3 list-disc mt-4 pl-4 text-sm text-gray-800">
                <li>
                  Autor : {product.author}
                </li>
                <li>
                  {product.pages} páginas
                </li>
                <li>
                  idioma {product.language}
                </li>
                <li>
                  Editora : {product.publishingCompany}
                </li>
                <li>
                  Data de publicação : {product.publicationDate}
                </li>
                <li>
                  ISBN10 : {product.isbn10}
                </li>
                <li>
                  ISBN13 : {product.isbn13}
                </li>
                <li>
                  Dimensões : {product.dimensions}
                </li>
                <li>
                  Formato :{product.format}
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default ProductDetailsCard;