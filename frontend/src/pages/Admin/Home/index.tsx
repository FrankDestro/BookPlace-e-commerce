import { useEffect, useState } from "react";
import { UserDTO } from "../../../models/user";
import * as userService from "../../../services/user-service";
import './styles.css';

function AdminHome() {

    const [user, setUser] = useState<UserDTO>();
    
    useEffect(() => {
        userService.findUserLogged().
            then((response) => {
                setUser(response.data);
            })
    }, []);

    return (
        <div>
            <main>
                <section id="admin-home-section" className="book-container">
                    <h2 className="dsc-section-title dsc-mb20">
                        Bem-vindo à área administrativa {user?.fullName}
                    </h2>
                </section>
            </main>
        </div>
    )
}

export default AdminHome
