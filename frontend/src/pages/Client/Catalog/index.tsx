/* eslint-disable @typescript-eslint/no-explicit-any */
import { useEffect, useState } from "react";
import { v4 as uuidv4 } from 'uuid'; // Importe a função uuidv4 para gerar chaves únicas
import ButtonNextPage from "../../../components/ButtonNextPage";
import CatalogCardBook from "../../../components/CatalogCardBook";
import SearchBar from "../../../components/SearchBar";
import { ProductDTO } from "../../../models/product";
import * as productService from "../../../services/product-service";
import './styles.css';

type QueryParams = {
  page: number;
  name: string;
};

function Catalog() {

  const [isLastPage, setIsLastPage] = useState(false);

  const [products, setProducts] = useState<ProductDTO[]>([]);

  const [queryParams, setQueryParams] = useState<QueryParams>({
    page: 0,
    name: "",
  });

  useEffect(() => {
    productService
      .findPageRequest(queryParams.page, queryParams.name)
      .then((response) => {
        const nextPage = response.data.content.map((item: any) => ({
          ...item,
          key: uuidv4()
        }));
        setProducts(prevProducts => prevProducts.concat(nextPage));
        setIsLastPage(response.data.last);
      })
      .catch(error => {
        console.error('Erro ao buscar produtos:', error);
      });
  }, [queryParams]);

  function handleSearch(searchText: string) {
    setProducts([]);
    setQueryParams({ ...queryParams, page: 0, name: searchText });
  }

  function handleNextPageClick() {
    setQueryParams({ ...queryParams, page: queryParams.page + 1 });
  }

  return (
    <main>
      <section id="catalog-section" className="book-container">
        <SearchBar onSearch={handleSearch} />
        <div className="book-catalog-cards dsc-mb20 dsc-mt20">
          {products.map((product) => (
            <CatalogCardBook key={product.id} product={product} />
          ))}
        </div>
        {!isLastPage ? (
          <div className="container" onClick={handleNextPageClick}>
            <ButtonNextPage text={"Carregar Mais"} />
          </div>
        ) : (
          <div className="container" onClick={handleNextPageClick}>
            Sem itens a serem mostrados
          </div>
        )}
      </section>
    </main>
  );
}

export default Catalog;




