import { Route, Routes } from "react-router-dom";
import RegisterUserPage from "./pages/RegisterUserPage";
import Profile from "./pages/profile/Profile";

function App() {
    return (
        <Routes>
            <Route path="/" element={<RegisterUserPage />} />
            <Route path="/profile" element={<Profile />} />
        </Routes>
    );
}

export default App;
