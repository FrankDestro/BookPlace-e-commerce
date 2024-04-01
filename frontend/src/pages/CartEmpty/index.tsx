import EmptyCart from "../../assets/img/empty-cart.png"

function CartEmpty() {
    return (
        <main>
            <section id="catalog-section" className="book-container">
            <img src={EmptyCart}></img>
            </section>
        </main>
    )
}

export default CartEmpty
