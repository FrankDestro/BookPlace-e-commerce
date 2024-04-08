import { useEffect, useRef, useState } from "react";
import './styles.css';

function HeaderAdminNavbarRight() {

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


    return (
        <nav>
      <div className="book-admin-navbar-right">
        <h3>Olá, Juliano@gmail.com</h3>
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
              className="absolute left-0 mt-2 bg-white divide-y divide-gray-300 rounded-lg shadow w-44 dark:bg-gray-700 dark:divide-gray-300"
            >
              <ul className="py-2 text-sm text-gray-700 dark:text-gray-900" aria-labelledby="avatarButton">
                <li>
                  <a href="#" className="block px-4 py-2 hover:bg-gray-700 dark:hover:bg-gray-600 dark:hover:text-white">
                    Dashboard
                  </a>
                </li>
                <li>
                  <a href="#" className="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">
                    Settings
                  </a>
                </li>
                <li>
                  <a href="#" className="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">
                    Earnings
                  </a>
                </li>
              </ul>
              <div className="py-1">
                <a href="#" className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-black-600 dark:hover:text-white">
                  Sign out
                </a>
              </div>
            </div>
          )}
        </div>
      </div>
    </nav>
    )
}

export default HeaderAdminNavbarRight
