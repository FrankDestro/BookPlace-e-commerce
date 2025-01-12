import { Outlet } from "react-router-dom"
import HeaderAdmin from "../../components/HeaderAdmin"

function Admin() {
    return (
        <div>
            <div>
                <HeaderAdmin />
                <Outlet />
            </div>
        </div>
    )
}

export default Admin
