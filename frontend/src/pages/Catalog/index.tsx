import CatalogCardBook from "../../components/CatalogCardBook";
import SearchBar from "../../components/SearchBar";

import './styles.css';

function Catalog() {
  return (
    <main>
      <section id="catalog-section" className="book-container">
        <SearchBar />
        <div className="book-catalog-cards dsc-mb20 dsc-mt20">
           <CatalogCardBook/>
           <CatalogCardBook/>
           <CatalogCardBook/>
           <CatalogCardBook/>
           <CatalogCardBook/>
           <CatalogCardBook/>
           <CatalogCardBook/>
           <CatalogCardBook/>
           <CatalogCardBook/>
           <CatalogCardBook/>
           <CatalogCardBook/>
           <CatalogCardBook/>
          </div>
      </section>
    </main>
  );
}

export default Catalog;
