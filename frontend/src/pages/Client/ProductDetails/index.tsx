import { useParams } from "react-router-dom";
import ProductDetailsCard from "../../../components/ProductDetailsCard"
import './styles.css';
import { useEffect, useState } from "react";
import * as productService from "../../../services/product-service";
import { ProductDTO } from "../../../models/product";

function ProductDetails() {

  const params = useParams();

  const [product, setProduct] = useState<ProductDTO>();

  useEffect(() => {
    productService
      .findById(Number(params.productId))
      .then((response) => {
        console.log(response.data);
        setProduct(response.data);
      })
      .catch((error) => {
        console.log(error)
      });
  }, []);

  return (
    <div id="product-details-section" className="book-container">
      {product && <ProductDetailsCard product={product} />}
    </div>
  )
}

export default ProductDetails
