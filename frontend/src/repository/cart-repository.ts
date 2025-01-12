import { OrderDTO, OrderItemDTO } from "../models/order";
import { CART_KEY } from "../utils/system";

export function save(cart: OrderDTO) {
  const srt = JSON.stringify(cart);
  localStorage.setItem(CART_KEY, srt);
}

export function get(): OrderDTO {
  const str = localStorage.getItem(CART_KEY) || '{"item":[]}';
  const obj = JSON.parse(str) as OrderDTO;

  const cart = new OrderDTO();

  if (obj.items && obj.items.length > 0) {
    obj.items.forEach((x) => {
      cart.items.push(
        new OrderItemDTO(x.productId, x.quantity, x.name, x.price, x.imgUrl)
      );
    });
    return cart;
  } else {
    return cart;
  }
}

export function clear() {
  localStorage.setItem(CART_KEY, '{"item":[]}');
}


export function removeItem(productIdToRemove: number): void {
  const cartStr = localStorage.getItem(CART_KEY) || '{"items":[]}';
  const cart = JSON.parse(cartStr);
  const indexToRemove = cart.items.findIndex((item: any) => item.productId === productIdToRemove);
  
  if (indexToRemove !== -1) {
    cart.items.splice(indexToRemove, 1);
    localStorage.setItem(CART_KEY, JSON.stringify(cart));
  }
}