import CartIcon from "../CartIcon"
import LoogedUser from "../LoogedUser"
import WishList from "../WishList"
import './styles.css'

function HeaderNavbarRight() {
    
    return (
        <nav>
            <div className="book-navbar-right">
                <div>
                    <LoogedUser/>
                </div>
                <div>
                    <WishList />
                </div>
                <div>
                    <CartIcon />
                </div>
            </div>
        </nav>
    )
}

export default HeaderNavbarRight
