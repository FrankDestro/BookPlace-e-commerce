import EmptyCart from "../../assets/img/empty-cart.png"

import './styles.css';

function CartEmpty() {
    return (
        <main>
            <section id="cart-empty-section" className="book-container">
                <img src={EmptyCart}></img>
                <p>Seu carrinho esta vazio!</p>
            </section>
        </main>
    )
}

export default CartEmpty
