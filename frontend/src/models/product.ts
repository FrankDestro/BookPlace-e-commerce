import { CategoryDTO } from "./category";
import { ProductImage } from "./productImage";

export type ProductDTO = {
    id: number;
    name: string;
    price: number;
    cashPrice: number;
    installmentPrice: number;
    description: string;
    details: string;
    productImages: ProductImage[];
    categories : CategoryDTO[];
    author: string;
    pages: 1178,
    language: string,
    publishingCompany: string
    publicationDate: string
    isbn10: string
    isbn13: string
    dimensions: string
    format: string;
}