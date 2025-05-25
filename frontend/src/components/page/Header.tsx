import { Link, useLocation } from 'react-router-dom';

const Header = () => {
    const location = useLocation();
    const isLoggedIn = false; // TODO: Replace with actual auth logic later
    const showAuthHeader = location.pathname === '/' && !isLoggedIn;

    return (
        <header className="bg-white shadow-md py-4">
            <div className="container mx-auto px-4 flex justify-between items-center">
                {showAuthHeader ? (
                    <div className="w-full flex justify-center">
                        <Link 
                            to="/" 
                            className="text-2xl font-bold text-indigo-600 hover:text-indigo-800"
                        >
                            Jumghor
                        </Link>
                    </div>
                ) : (
                    <>
                        <Link 
                            to="/feed" 
                            className="text-indigo-600 hover:text-indigo-800 font-medium"
                        >
                            Home
                        </Link>
                        <Link 
                            to="/profile" 
                            className="text-indigo-600 hover:text-indigo-800 font-medium"
                        >
                            Profile
                        </Link>
                    </>
                )}
            </div>
        </header>
    );
};

export default Header;
