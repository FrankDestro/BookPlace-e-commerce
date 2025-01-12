import { useContext, useEffect, useRef, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import * as authService from "../../services/auth-service";
import { ContextToken } from "../../utils/context-token";
import './styles.css';

function LoogedUser() {

  const { contextTokenPayload, setContextTokenPayload } = useContext(ContextToken);

  const navigate = useNavigate();

  const [showDropdown, setShowDropdown] = useState(false);
  const dropdownRef = useRef<HTMLDivElement>(null);

  useEffect(() => {
    const handleClickOutside = (event: MouseEvent) => {
      if (dropdownRef.current && !dropdownRef.current.contains(event.target as Node)) {
        setShowDropdown(false);
      }
    };

    document.addEventListener('mousedown', handleClickOutside);

    return () => {
      document.removeEventListener('mousedown', handleClickOutside);
    };
  }, []);

  const toggleDropdown = () => {
    setShowDropdown(!showDropdown);
  };

  function handleLogoutClick() {
    authService.Logout()
    setContextTokenPayload(undefined);
    navigate("/")
  }


  return (

    contextTokenPayload && authService.isAuthenticated()
      ? (
        <nav>
          <div className="book-admin-navbar-right">
            <h3>Olá, {contextTokenPayload.username.split("@")[0].split(".")[0].charAt(0).toUpperCase() + contextTokenPayload.username.split("@")[0].split(".")[0].slice(1)}</h3>
            <div className="relative" ref={dropdownRef}>
              <img
                id="avatarButton"
                data-dropdown-toggle="userDropdown"
                data-dropdown-placement="bottom-start"
                className="w-10 h-10 rounded-full cursor-pointer"
                src="https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80"
                alt="User dropdown"
                onClick={toggleDropdown}
              />

              {showDropdown && (
                <div
                  id="userDropdown"
                  className="absolute mt-2 bg-white divide-y divide-gray-300 rounded-lg shadow w-44 dark:bg-gray-700 dark:divide-gray-300"
                >
                  <ul className="py-2 text-sm text-gray-700 dark:text-gray-900" aria-labelledby="avatarButton">
                    {/* <li>
                      {authService.hasAnyRoles(["ROLE_ADMIN"]) &&
                        contextTokenPayload &&
                          <a href="/admin" className="block px-4 py-2 hover:bg-gray-700 dark:hover:bg-gray-600 dark:hover:text-white">
                            Area Admin
                          </a>
                      }
                    </li> */}
                    <li>
                      <a href="#" className="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">
                        Settings
                      </a>
                    </li>
                  </ul>
                  <div className="py-1">
                    <a href="#" className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-black-600 dark:hover:text-white">
                      <span onClick={handleLogoutClick}> Sair </span>
                    </a>
                  </div>
                </div>
              )}
            </div>
          </div>
        </nav>
      ) : (
        <div>
          <Link to="/login">
            <h3 style={{ fontSize: "16px", fontWeight: "700", marginRight: "5PX" }}>Entrar</h3>
          </Link>
        </div>
      )
  )
}

export default LoogedUser
