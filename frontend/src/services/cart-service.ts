import { OrderDTO, OrderItemDTO } from "../models/order";
import { ProductDTO } from "../models/product";
import * as cartRepository from "../repository/cart-repository";

export function saveCart(cart: OrderDTO) {
  cartRepository.save(cart);
}

export function getCart(): OrderDTO {
  return cartRepository.get();
}

export function addProduct(product: ProductDTO) {
  const cart = cartRepository.get();

  if (!cart.items || cart.items.length <= 0) {
    const newItem = new OrderItemDTO(
      product.id,
      1,
      product.name,
      product.price,
      product.productImages[0].imageUrl
    );
    cart.items = [newItem];
    cartRepository.save(cart);
  } else {
    const item = cart.items.find((x) => x.productId === product.id);
    if (!item) {
      const newItem = new OrderItemDTO(
        product.id,
        1,
        product.name,
        product.price,
        product.productImages[0].imageUrl
      );
      cart.items.push(newItem);
      cartRepository.save(cart);
    }
  }
}

export function clearCart() {
  cartRepository.clear();
}

export function increaseItem(productId: number) {
  const cart = cartRepository.get();
  const item = cart.items.find((x) => x.productId === productId);

  if (item) {
    item.quantity++;
    cartRepository.save(cart);
  }
}

export function decreaseItem(productId: number) {
  const cart = cartRepository.get();
  const item = cart.items.find((x) => x.productId === productId);

  if (item) {
    item.quantity--;
    if (item.quantity < 1) {
      cart.items = cart.items.filter((x) => x.productId !== productId);
    }
    cartRepository.save(cart);
  }
}

export function removeItem(productIdToRemove: number): void {
  cartRepository.removeItem(productIdToRemove);
}